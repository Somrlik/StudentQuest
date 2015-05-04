package cz.cvut.fel.syrovkar.rpgEngine;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Direction;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Location;
import cz.cvut.fel.syrovkar.rpgEngine.gui.Canvas;
import cz.cvut.fel.syrovkar.rpgEngine.gui.MainWindow;
import cz.cvut.fel.syrovkar.rpgEngine.gui.PlayerInteraction;
import cz.cvut.fel.syrovkar.rpgEngine.init.GameRegistry;
import cz.cvut.fel.syrovkar.rpgEngine.init.Init;
import cz.cvut.fel.syrovkar.rpgEngine.reference.Constants;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Enemy;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Entity;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Item;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Player;

import java.awt.*;

/**
 * Central hub for controlling the engine.
 *
 * Created by Karel on 24. 2. 2015.
 */
public class Game implements Runnable {

    /**
     * Used for rendering the Game
     */
    public static Canvas canvas;

    /**
     * Encases all locations, archetypes and the player
     */
    public static GameRegistry gameRegistry;

    /**
     * True if the Game Thread is running
     */
    public static volatile boolean isRunning = false;

    /**
     * True if the Canvas is Ready to be drawn on.
     */
    public static volatile boolean isReady = false;

    /**
     * Current location of the Player
     */
    public static Location currentLocation;

    private Player player;

    /**
     * Runs the Game. Do not use.
     */
    public Game() {
        isRunning = true;
        canvas = MainWindow.canvas;
        gameRegistry = new GameRegistry();
        Init.init();
        player = gameRegistry.getPlayer();
    }

    private double delta = 1;

    @Override
    public void run() {

        long time;
        double timeDiff;

        /**
         * Game mainloop.
         */
        while (isRunning) {

            if (!isReady) {
                if (canvas.getDrawingGraphics() == null) {
                    continue;
                } else isReady = true;
            }

            time = System.nanoTime();

            gameLogic(delta);

            update();

            timeDiff = System.nanoTime() - time;

            timeDiff /= 1e9; // in seconds

            delta = timeDiff;

        }
    }

    /**
     * Updates the whole game logic and screen. Computes the time between frames for possibility of FIM.
     */
    private void update() {
/*
        int k = 0;
        while(k < 1e7) { //just for slowing down
            Math.sqrt(k);
            k++;
        }
*/
        Graphics2D screen = canvas.getDrawingGraphics();

        screen.clearRect(-1, -1, Constants.WINDOW_WIDTH + 1, Constants.WINDOW_HEIGHT + 1);

        screen.drawString("FPS: " + Double.toString(1 / delta), 10, 10);

        player.draw(screen, delta);

        for (Entity e : currentLocation.getEntities()) {
            e.draw(screen, delta);
        }

        for (Enemy e : currentLocation.getEnemies()) {
            e.draw(screen, delta);
        }

        for (Item i : currentLocation.getItems()) {
            i.draw(screen, delta);
        }

        canvas.update();

    }

    /**
     * Does logical stuff.
     *
     * @param delta Time difference between frames of the Game
     */
    private void gameLogic(double delta) {
        playerLogic(delta);
    }

    /**
     * Does playerLogic and interaction
     *
     * @param delta Time difference between frames of the Game
     */
    private void playerLogic(double delta) {

        /* MOVING */

        if (PlayerInteraction.isDownPressed) player.move(Direction.DOWN, delta);
        if (PlayerInteraction.isUpPressed) player.move(Direction.UP, delta);
        if (PlayerInteraction.isRightPressed) player.move(Direction.RIGHT, delta);
        if (PlayerInteraction.isLeftPressed) player.move(Direction.LEFT, delta);

        if (!(PlayerInteraction.isDownPressed || PlayerInteraction.isUpPressed)) player.stopInY(delta);
        if (!(PlayerInteraction.isRightPressed || PlayerInteraction.isLeftPressed)) player.stopInX(delta);

        if (!(PlayerInteraction.isRightPressed || PlayerInteraction.isDownPressed || PlayerInteraction.isLeftPressed || PlayerInteraction.isUpPressed))
            gameRegistry.getPlayer().slowDown(delta);

        /* BORDER COLLISION */

        if (player.getX() < -1) {
            player.stopInX(delta);
            player.setX(0);
        }

        if (player.getY() < -1) {
            player.stopInX(delta);
            player.setY(0);
        }

        if ((player.getX() + player.getxSize() > canvas.getWidth() + 1)) {
            player.stopInX(delta);
            player.setX(canvas.getWidth() - player.getxSize());
        }
        if ((player.getY() + player.getySize() > canvas.getHeight() + 1)) {
            player.stopInY(delta);
            player.setY(canvas.getHeight() - player.getySize());
        }


    }
}

