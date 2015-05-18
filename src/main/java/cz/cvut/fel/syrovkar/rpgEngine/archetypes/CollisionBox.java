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
        return this.x < other.x + other.sizeX &&
                this.x + this.sizeX > other.x &&
                this.y < other.y + other.sizeY &&
                this.y + this.sizeY > other.y;
    }
}
