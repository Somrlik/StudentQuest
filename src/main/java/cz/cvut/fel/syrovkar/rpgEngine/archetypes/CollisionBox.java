package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

/**
 * For easier handling of collisions
 * <p/>
 * Created by Karel on 5. 5. 2015.
 */
public class CollisionBox {

    private int x;
    private int y;

    private int sizeX;
    private int sizeY;

    public CollisionBox(double x, double y, double sizeX, double sizeY) {
        this.x = (int) x;
        this.y = (int) y;
        this.sizeX = (int) sizeX;
        this.sizeY = (int) sizeY;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public boolean collidesWith(CollisionBox other) {
        return this.x < other.x + other.sizeX &&
                this.x + this.sizeX > other.x &&
                this.y < other.y + other.sizeY &&
                this.y + this.sizeY > other.y;
    }
}
