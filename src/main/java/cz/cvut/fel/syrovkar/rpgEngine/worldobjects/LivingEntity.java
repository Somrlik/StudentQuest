package cz.cvut.fel.syrovkar.rpgEngine.worldobjects;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Direction;

import java.awt.*;

/**
 * Used for interactive Entities in the Location.
 *
 * Created by Karel on 1. 4. 2015.
 */
public class LivingEntity extends Entity {
    protected double xVelocity;
    protected double yVelocity;

    public LivingEntity(String name, String id, int x, int y, int xSize, int ySize) {
        super(name, id, x, y, xSize, ySize);
        xVelocity = 0;
        yVelocity = 0;
    }

    @Override
    public void draw(Graphics g, double delta) {
        super.draw(g, delta);
        x += xVelocity * (delta);
        y += yVelocity * (delta);
        g.drawString("Entity with speed " + Double.toString(xVelocity) + " " + Double.toString(yVelocity), (int) x, (int) y + 10);
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

}
