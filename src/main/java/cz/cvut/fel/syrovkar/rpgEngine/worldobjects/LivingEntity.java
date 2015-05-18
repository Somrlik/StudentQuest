package cz.cvut.fel.syrovkar.rpgEngine.worldobjects;

import cz.cvut.fel.syrovkar.rpgEngine.utils.ImageHelper;

import java.awt.*;
import java.util.logging.Logger;

/**
 * Used for interactive Entities in the Location.
 *
 * Created by Karel on 1. 4. 2015.
 */
public class LivingEntity extends Entity {

    private static final Logger LOG = Logger.getLogger(LivingEntity.class.getName());

    protected double xVelocity;
    protected double yVelocity;

    protected Direction direction = Direction.UP;

    public LivingEntity(String name, String id, int x, int y, int xSize, int ySize) {
        super(name, id, x, y, xSize, ySize);
        xVelocity = 0;
        yVelocity = 0;
    }

    @Override
    public void draw(Graphics g, double delta) {
        //super.draw(g, delta);

        if (hasTexture) {
            int angle = 0;
            switch (direction) {
                case UP:
                    angle = 0;
                    break;
                case DOWN:
                    angle = 180;
                    break;
                case LEFT:
                    angle = 270;
                    break;
                case RIGHT:
                    angle = 90;
                    break;
            }

            g.drawImage(ImageHelper.rotateImage(texture, angle), (int) x, (int) y, (int) xSize, (int) ySize, null);

        } else g.fillRect((int) x, (int) y, (int) xSize, (int) ySize);

        x += xVelocity * (delta);
        y += yVelocity * (delta);
        //g.drawString("Entity with speed " + Double.toString(xVelocity) + " " + Double.toString(yVelocity), (int) x, (int) y + 10);
    }

    /**
     * Slows down (stops) the Entity
     *
     * @param delta Time difference between frames of the Game
     */
    public void slowDown(double delta) {
        yVelocity = 0;
        xVelocity = 0;
    }

    /**
     * Stops in X axis.
     *
     * @param delta Time difference between frames of the Game
     */
    public void stopInX(double delta) {
        xVelocity = 0;
    }

    /**
     * Stops in Y axis.
     * @param delta Time difference between frames of the Game
     */
    public void stopInY(double delta) {
        yVelocity = 0;
    }

    /**
     * Move in a Direction
     * @param direction direction to move in
     * @param delta Time difference between frames of the Game
     */
    public void move(Direction direction, double delta) {

    }

    public double getxVelocity() {
        return xVelocity;
    }

    public double getyVelocity() {
        return yVelocity;
    }

    @Override
    public boolean collideWith(Entity e) {
        return this.hitbox.collidesWith(e.hitbox);
    }



}
