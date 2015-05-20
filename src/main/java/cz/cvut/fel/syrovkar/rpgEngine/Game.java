package cz.cvut.fel.syrovkar.rpgEngine;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Location;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.WorldMap;
import cz.cvut.fel.syrovkar.rpgEngine.gui.Canvas;
import cz.cvut.fel.syrovkar.rpgEngine.gui.MainWindow;
import cz.cvut.fel.syrovkar.rpgEngine.gui.Overlay;
import cz.cvut.fel.syrovkar.rpgEngine.gui.PlayerInteraction;
import cz.cvut.fel.syrovkar.rpgEngine.init.GameRegistry;
import cz.cvut.fel.syrovkar.rpgEngine.reference.Constants;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.*;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;

/**
 * Central hub for controlling the engine.
 *
 * Created by Karel on 24. 2. 2015.
 */
public class Game implements Runnable {

    private static final Logger LOG = Logger.getLogger(Game.class.getName());

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

    /**
     * True if the game is paused
     */
    private static volatile boolean isPaused = false;

    /**
     * Not really used here.
     */
    private Player player;

    /**
     * Runs the Game. Do not use.
     */
    public Game() {
        isRunning = true;
        canvas = MainWindow.canvas;

        //player = gameRegistry.getPlayer();
    }

    private double delta = 1;

    /**
     * Game mainloop.
     */
    @Override
    public void run() {

        long time;
        double timeDiff;

        LOG.info("Running Loading mainloop...");

        while (isRunning) {

            if (!isReady) {
                if (canvas.getDrawingGraphics() == null) {
                    continue;
                } else {
                    LOG.info("Canvas is ready...");
                    isReady = true;
                }
            }

            if (!GameRegistry.isLoaded || gameRegistry == null) {
                // Your IDE is lying - NullPointer is impossible
                canvas.getDrawingGraphics().drawString("Loading", Constants.WINDOW_WIDTH / 2, Constants.WINDOW_HEIGHT / 2);
                canvas.update();
            } else {
                player = gameRegistry.getPlayer();
                isRunning = false;
            }
        }

        LOG.info("Running Game mainloop...");

        isRunning = true;

        while (isRunning) {

            time = System.nanoTime();

            if (!isPaused) {
                gameLogic(delta);
            } else {
                for (LivingEntity e : currentLocation.getEnemies()) {
                    e.slowDown(delta);
                }
                player.slowDown(delta);
            }

            overlayLogic(delta);

            update();

            timeDiff = System.nanoTime() - time;

            timeDiff /= 1e9; // in seconds

            delta = timeDiff;

        }

        LOG.info("Mainloop ended...");
    }

    private void overlayLogic(double delta) {
        for (Overlay o : gameRegistry.getOverlays()) {
            o.listenToInput();
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
        if (screen == null) return;

        screen.clearRect(-1, -1, Constants.WINDOW_WIDTH + 1, Constants.WINDOW_HEIGHT + 1);

        screen.setColor(currentLocation.getBackground());
        screen.fillRect(canvas.getX(), canvas.getY(), Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        screen.setColor(Color.black);

        for (Entity e : currentLocation.getEntities()) {
            e.draw(screen, delta);
        }

        for (Enemy e : currentLocation.getEnemies()) {
            e.draw(screen, delta);

        }

        for (Item i : currentLocation.getItems()) {
            i.draw(screen, delta);
        }

        player.draw(screen, delta);

        // Overlays

        for (Overlay o : gameRegistry.getOverlays()) {
            if (o.isOpened()) {
                o.draw(screen, delta);
            }
        }

        canvas.update();

    }

    /**
     * Does logical stuff.
     *
     * @param delta Time difference between frames of the Game
     */
    private synchronized void gameLogic(double delta) {

        playerLogic(delta);

        enemyLogic(delta);

        // Collision
        for (Entity e : currentLocation.getEntities()) {
            player.collideWith(e, delta);
        }

        for (Item item : currentLocation.getItems()) {
            player.collideWith(item, delta);
        }

        for (Enemy e : currentLocation.getEnemies()) {
            player.collideWith(e, delta);
        }

        // Synchro
        if (GameRegistry.itemsToDelete != null) {
            currentLocation.getItems().removeAll(GameRegistry.itemsToDelete);
            GameRegistry.itemsToDelete = null;
        }

        if (GameRegistry.enemiesToDelete != null) {
            currentLocation.getEnemies().removeAll(GameRegistry.enemiesToDelete);
            GameRegistry.enemiesToDelete = null;
        }

    }

    /**
     * Does enemy logic - AI, pathing etc.
     *
     * @param delta Time difference between frames of the Game
     */
    private void enemyLogic(double delta) {
        for (Enemy enemy : currentLocation.getEnemies()) {
            enemy.updateAI(delta);
        }
    }

    /**
     * Does playerLogic and interaction
     *
     * @param delta Time difference between frames of the Game
     */
    private void playerLogic(double delta) {

        /* MOVING */

        if (PlayerInteraction.isRightPressed) player.move(Direction.RIGHT, delta);
        if (PlayerInteraction.isLeftPressed) player.move(Direction.LEFT, delta);
        if (PlayerInteraction.isDownPressed) player.move(Direction.DOWN, delta);
        if (PlayerInteraction.isUpPressed) player.move(Direction.UP, delta);

        if (PlayerInteraction.isRightPressed || PlayerInteraction.isLeftPressed) {
            if (player.getyVelocity() != 0) {
                player.stopInY(delta);
                if (PlayerInteraction.isRightPressed) player.move(Direction.RIGHT, delta);
                if (PlayerInteraction.isLeftPressed) player.move(Direction.LEFT, delta);
            }
        } else if (PlayerInteraction.isDownPressed || PlayerInteraction.isUpPressed) {
            if (player.getxVelocity() != 0) {
                player.stopInX(delta);
                if (PlayerInteraction.isDownPressed) player.move(Direction.DOWN, delta);
                if (PlayerInteraction.isUpPressed) player.move(Direction.UP, delta);
            }
        }
/*
        if (player.getxVelocity() == 0) {

        }
        else if (player.getyVelocity() == 0) {
        }
/*
        if (player.getxVelocity() != 0) player.stopInX(delta);
        if (player.getyVelocity() != 0) player.stopInY(delta);

        // stopping the player
        if (!(PlayerInteraction.isDownPressed || PlayerInteraction.isUpPressed)) player.stopInY(delta);
        if (!(PlayerInteraction.isRightPressed || PlayerInteraction.isLeftPressed)) player.stopInX(delta);
*/
        if (!(PlayerInteraction.isRightPressed || PlayerInteraction.isDownPressed || PlayerInteraction.isLeftPressed || PlayerInteraction.isUpPressed))
            player.slowDown(delta);

        /* LOCATIONS SWITCHING */

        if (player.getX() < -1) {
            switchLocations(Direction.LEFT);
        }

        if (player.getY() < -1) {
            switchLocations(Direction.UP);
        }

        if ((player.getX() + player.getxSize() > canvas.getWidth() + 1)) {
            switchLocations(Direction.RIGHT);
        }
        if ((player.getY() + player.getySize() > canvas.getHeight() + 1)) {
            switchLocations(Direction.DOWN);
        }

    }

    /**
     * Pauses the Game
     */
    public static void pause() {
        isPaused = true;
        LOG.info("Paused game");
    }

    /**
     * Unpauses the Game.
     */
    public static void unpause() {
        isPaused = false;
        LOG.info("Unpaused game");
    }

    /**
     * Standard exit procedure.
     */
    public static synchronized void exit() {
        Game.pause();
        isRunning = false;
    }

    /**
     * Exiting when something failed horribly.
     */
    public static void exitFail() {
        LOG.severe("ExitFail called, something terrible happened!");
        Game.pause();
        isRunning = false;
        MainWindow.frame.dispatchEvent(new WindowEvent(MainWindow.frame, WindowEvent.WINDOW_CLOSING));
    }

    /**
     * Switches locations with respect to WorldMap
     *
     * @param direction Which Direction the player goes
     */
    private void switchLocations(Direction direction) {
        Game.pause();
        WorldMap worldMap = gameRegistry.getWorld();
        Location loc = null;
        switch (direction) {
            case UP:
                loc = worldMap.getLocationAt(worldMap.getCurrentI() - 1, worldMap.getCurrentJ());
                break;
            case DOWN:
                loc = worldMap.getLocationAt(worldMap.getCurrentI() + 1, worldMap.getCurrentJ());
                break;
            case RIGHT:
                loc = worldMap.getLocationAt(worldMap.getCurrentI(), worldMap.getCurrentJ() + 1);
                break;
            case LEFT:
                loc = worldMap.getLocationAt(worldMap.getCurrentI(), worldMap.getCurrentJ() - 1);
                break;
        }
        if (loc != null) {
            currentLocation.setIsPlayerHere(false);
            currentLocation = loc;
            currentLocation.setIsPlayerHere(true);
            worldMap.setCurrentI(currentLocation.getI());
            worldMap.setCurrentJ(currentLocation.getJ());

            switch (direction) {
                case UP:
                    player.setY(canvas.getHeight() - player.getySize() - 5);
                    player.stopInY(delta);
                    break;
                case DOWN:
                    player.setY(5);
                    player.stopInY(delta);
                    break;
                case RIGHT:
                    player.setX(5);
                    player.stopInX(delta);
                    break;
                case LEFT:
                    player.setX(canvas.getWidth() - player.getxSize() - 5);
                    player.stopInX(delta);
                    break;
            }

            LOG.fine("Changed location successfully, currently on " + currentLocation.getId() + " with i: " + currentLocation.getI() + "/" + worldMap.getCurrentI() + "j: " + currentLocation.getJ() + "/" + worldMap.getCurrentJ());
            Game.unpause();
            return;
        }
        LOG.fine("Didn't change location (is there any in the map?)");

        switch (direction) {
            case UP:
                player.setY(1);
                player.stopInY(delta);
                break;
            case DOWN:
                player.setY(canvas.getHeight() - player.getySize() - 1);
                player.stopInY(delta);
                break;
            case RIGHT:
                player.setX(canvas.getWidth() - player.getxSize() - 1);
                player.stopInX(delta);
                break;
            case LEFT:
                player.setX(1);
                player.stopInX(delta);
                break;
        }
        Game.unpause();
    }
}

