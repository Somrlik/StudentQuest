package cz.cvut.fel.syrovkar.rpgEngine;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Direction;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Item;
import cz.cvut.fel.syrovkar.rpgEngine.gui.Canvas;
import cz.cvut.fel.syrovkar.rpgEngine.gui.MainWindow;
import cz.cvut.fel.syrovkar.rpgEngine.gui.PlayerInteraction;
import cz.cvut.fel.syrovkar.rpgEngine.init.GameRegistry;
import cz.cvut.fel.syrovkar.rpgEngine.init.Init;
import cz.cvut.fel.syrovkar.rpgEngine.reference.Constants;

import java.awt.*;

/**
 * Central hub for controlling the engine.
 *
 * Created by Karel on 24. 2. 2015.
 */
public class Game implements Runnable {

    public static Canvas canvas;

    public static GameRegistry gameRegistry;

    public static volatile boolean isRunning = false;

    private Player player;

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

        while (isRunning) {

            time = System.nanoTime();

            gameLogic(delta);

            update();

            timeDiff = System.nanoTime() - time;

            timeDiff /= 1e9; //za sekundu

            delta = timeDiff;

        }
    }

    private void update() {
/*
        int k = 0;
        while(k < 1e7) { //just for slowing down
            Math.sqrt(k);
            k++;
        }
*/
        Graphics2D screen = canvas.getDrawingGraphics();

        if (screen != null) {
            screen.clearRect(-1, -1, Constants.WINDOW_WIDTH + 1, Constants.WINDOW_HEIGHT + 1);

            screen.drawString("FPS: " + Double.toString(1 / delta), 10, 10);

            player.draw(screen, delta);

            for (Item i : gameRegistry.getItems()) {
                i.draw(screen, delta);
            }

            for (cz.cvut.fel.syrovkar.rpgEngine.archetypes.Character ch : gameRegistry.getCharacters()) {
                ch.draw(screen, delta);
            }

            canvas.update();
        }

    }

    private void gameLogic(double delta) {
        playerLogic(delta);
    }

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

