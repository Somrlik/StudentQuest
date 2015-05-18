package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

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

    /**
     * @return X coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * @param x New X coordinate
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return Y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * @param y New Y coordinate
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @param other Other collision box
     * @return True if they collide, false otherwise
     */
    public boolean collidesWith(CollisionBox other) {
        return this.x <= other.x + other.sizeX &&
                this.x + this.sizeX >= other.x &&
                this.y <= other.y + other.sizeY &&
                this.y + this.sizeY >= other.y;
    }

    /*
    public Direction collidesWithInDirection(CollisionBox other) {
        if (this.x <= other.x + other.sizeX) return Direction.LEFT;
        if (this.y <= other.y + other.sizeY) return Direction.UP;
        if (this.y + this.sizeY >= other.y) return Direction.DOWN;
        if (this.x + this.sizeX >= other.x) return Direction.RIGHT;
        return null;
    }
    */
}
