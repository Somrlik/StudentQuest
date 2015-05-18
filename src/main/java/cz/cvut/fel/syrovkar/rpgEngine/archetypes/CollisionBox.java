package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Direction;

/**
 * For easier handling of collisions
 * <p/>
 * Created by Karel on 5. 5. 2015.
 */
public class CollisionBox {

    private double x;
    private double y;

    private double sizeX;
    private double sizeY;

    public CollisionBox(double x, double y, double sizeX, double sizeY) {
        this.x = (int) x;
        this.y = (int) y;
        this.sizeX = (int) sizeX;
        this.sizeY = (int) sizeY;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean collidesWith(CollisionBox other) {
        return this.x <= other.x + other.sizeX &&
                this.x + this.sizeX >= other.x &&
                this.y <= other.y + other.sizeY &&
                this.y + this.sizeY >= other.y;
    }

    public Direction collidesWithInDirection(CollisionBox other) {
        if (this.x <= other.x + other.sizeX) return Direction.LEFT;
        if (this.y <= other.y + other.sizeY) return Direction.UP;
        if (this.y + this.sizeY >= other.y) return Direction.DOWN;
        if (this.x + this.sizeX >= other.x) return Direction.RIGHT;
        return null;
    }
}
