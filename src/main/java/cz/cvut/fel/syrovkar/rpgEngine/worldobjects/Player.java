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
        this.direction = direction;
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

        LOG.finest("Moving player from x:" + x + " y:" + y + "with Xspeed: " + xVelocity + " Yspeed: " + yVelocity);

        this.hitbox.setX((int) this.getX());
        this.hitbox.setY((int) this.getY());

    }

    @Override
    public boolean collideWith(Entity e) {
        if (super.collideWith(e)) {

            LOG.fine("Player collided with " + e.getId());
            LOG.finer("Original Player's x: " + x + " y:" + y);

            if (xVelocity == 0) {
                y += (yVelocity > 0) ? -1 : +1;
                yVelocity = 0;
                this.hitbox.setY(y);
            } else { // yVelocity == 0
                x += (xVelocity > 0) ? -1 : +1;
                xVelocity = 0;
                this.hitbox.setX(x);
            }

            LOG.finer("New Player's x: " + x + "y: " + y);

            return true;
        }
        return false;
    }

    public boolean collideWith(Item i) {
        if (super.collideWith(i)) {

            LOG.fine("Player collided with " + i.getId());

            return true;
        }

        return false;
    }


}
