package cz.cvut.fel.syrovkar.rpgEngine.worldobjects;

import java.util.logging.Logger;

/**
 * Player class.
 *
 * Created by Karel on 26. 2. 2015.
 */
public class Player extends LivingEntity {

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
    public boolean collideWith(Entity e, double delta) {
        if (super.collideWith(e, delta)) {

            LOG.fine("Player collided with " + e.getId());
            LOG.finer("Original Player's x: " + x + " y:" + y);

            // TODO: Fix getting stuck in entites

            x += -((xVelocity * 8) * delta);
            y += -((yVelocity * 8) * delta);

            this.hitbox.setX(x);
            this.hitbox.setY(y);

            //xVelocity = yVelocity = 0;

            LOG.finer("New Player's x: " + x + " y: " + y);

            return true;
        }
        return false;
    }

    public boolean collideWith(Item i, double delta) {
        if (super.collideWith(i, delta)) {

            LOG.fine("Player collided with " + i.getId());

            return true;
        }

        return false;
    }


}
