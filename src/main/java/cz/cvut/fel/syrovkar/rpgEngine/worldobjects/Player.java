package cz.cvut.fel.syrovkar.rpgEngine.worldobjects;

import java.util.logging.Logger;

/**
 * Player class.
 *
 * Created by Karel on 26. 2. 2015.
 */
public class Player extends Character {

    private static final Logger LOG = Logger.getLogger(Player.class.getName());

    public Player(int x, int y, int xSize, int ySize) {
        super("Player", "player", x, y, xSize, ySize);
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

        this.hitbox.setX((int) this.getX());
        this.hitbox.setY((int) this.getY());
        this.hitbox.setSizeX((int) this.getxSize());
        this.hitbox.setSizeY((int) this.getySize());

    }

}
