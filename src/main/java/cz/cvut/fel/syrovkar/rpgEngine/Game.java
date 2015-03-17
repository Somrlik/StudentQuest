package cz.cvut.fel.syrovkar.rpgEngine;

import cz.cvut.fel.syrovkar.rpgEngine.init.GameRegistry;

/**
 * Central hub for controlling the engine.
 *
 * Created by Karel on 24. 2. 2015.
 */
public class Game implements Runnable {

    public static GameRegistry gameRegistry = new GameRegistry();

    public static Player player = gameRegistry.getPlayer();

    private final int ticksPerSecond = 5;

    private boolean running = false;

    private static boolean modsLoaded = false;

    public Game() {
        this.running = true;
    }

    public synchronized void run() {
        while (this.running) {
            try {
                tick();
                this.wait(1000 / ticksPerSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isModsLoaded() {
        return modsLoaded;
    }

    /**
     * Tick the game engine.
     */
    public void tick() {
        System.out.println("Game ticks.");
    }

    public void init() {
        gameRegistry.invokeInitOnMods();
        this.modsLoaded = true;
    }

}
