package cz.cvut.fel.syrovkar.rpgEngine;

import cz.cvut.fel.syrovkar.rpgEngine.init.GameRegistry;

/**
 * Central hub for controlling the engine.
 *
 * Created by Karel on 24. 2. 2015.
 */
public class Game {

    public static GameRegistry gameRegistry = new GameRegistry();

    public static Player player = gameRegistry.getPlayer();

    private int ticksPerSecond = 20;

    public Game() {
    }

    /**
     * Tick the game engine.
     */
    public void tick() {

    }

    public void init() {
        gameRegistry.invokeInitOnMods();
    }

}
