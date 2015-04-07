package cz.cvut.fel.syrovkar.rpgEngine;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Direction;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Entity;
import cz.cvut.fel.syrovkar.rpgEngine.gui.Canvas;
import cz.cvut.fel.syrovkar.rpgEngine.gui.MainWindow;
import cz.cvut.fel.syrovkar.rpgEngine.gui.PlayerInteraction;

import java.awt.*;
import java.util.ArrayList;

/**
 * Central hub for controlling the engine.
 *
 * Created by Karel on 24. 2. 2015.
 */
public class Game implements Runnable {

    ArrayList<Entity> entities;

    Canvas canvas;

    public Player player;

    public static volatile boolean isRunning = false;

    public Game() {
        entities = new ArrayList<Entity>();
        addEntity(new Entity(10, 40));
        addEntity(new Entity(20, 30));
        isRunning = true;
        this.canvas = MainWindow.canvas;
        player = new Player();
        addEntity(player);
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
            screen.clearRect(0, 0, 800, 600);

            screen.drawString("FPS: " + Double.toString(1 / delta), 10, 10);

            for (Entity e : entities) {
                e.draw(screen, delta);
            }

            canvas.update();
        }

    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    private void gameLogic(double delta) {
        playerLogic(delta);
    }

    private void playerLogic(double delta) {
        if (PlayerInteraction.isUpPressed) player.move(Direction.UP, delta);
        if (PlayerInteraction.isDownPressed) player.move(Direction.DOWN, delta);
        if (PlayerInteraction.isRightPressed) player.move(Direction.RIGHT, delta);
        if (PlayerInteraction.isLeftPressed) player.move(Direction.LEFT, delta);
        if (!(!PlayerInteraction.isRightPressed && !PlayerInteraction.isLeftPressed)) player.stopInY(delta);
        if (!(!PlayerInteraction.isUpPressed && !PlayerInteraction.isDownPressed)) player.stopInX(delta);
        if (!(PlayerInteraction.isRightPressed || PlayerInteraction.isDownPressed || PlayerInteraction.isLeftPressed || PlayerInteraction.isUpPressed))
            player.slowDown(delta);
    }

}

