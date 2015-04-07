package cz.cvut.fel.syrovkar.rpgEngine;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Character;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Direction;

/**
 * Basic Player class.
 * <p/>
 * Created by Karel on 26. 2. 2015.
 */
public class Player extends Character {

    public Player() {
        super("Player");
    }

    @Override
    public void move(Direction direction, double delta) {
        switch (direction) {
            case UP:
                yVelocity = -64;
                break;
            case DOWN:
                yVelocity = 64;
                break;
            case LEFT:
                xVelocity = -64;
                break;
            case RIGHT:
                xVelocity = 64;
                break;
        }
    }

}
