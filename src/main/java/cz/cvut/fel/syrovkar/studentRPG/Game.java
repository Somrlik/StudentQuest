package cz.cvut.fel.syrovkar.studentRPG;

import cz.cvut.fel.syrovkar.studentRPG.init.GameRegistry;

/**
 * Central hub for controlling the engine.
 *
 * Created by Karel on 24. 2. 2015.
 */
public class Game {

    private static GameRegistry gameRegistry;

    public Game() {
        gameRegistry = new GameRegistry();
    }

}
