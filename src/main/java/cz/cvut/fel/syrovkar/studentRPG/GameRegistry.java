package cz.cvut.fel.syrovkar.studentRPG;

import cz.cvut.fel.syrovkar.studentRPG.init.Init;

import java.util.List;

/**
 * Created by Karel on 24. 2. 2015.
 */
public class GameRegistry {

    private List<Character> characters;

    private List<Enemy> enemies;

    private List<Item> items;

    public GameRegistry() {
        new Init();
    }


}