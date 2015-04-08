package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

import cz.cvut.fel.syrovkar.rpgEngine.gui.Drawable;

import java.awt.*;

/**
 * Created by Karel on 24. 3. 2015.
 */
public class Entity implements Drawable {

    protected double x;
    protected double y;

    protected double xSize;
    protected double ySize;

    protected boolean collides = false;

    public Entity(double x, double y, double xSize, double ySize) {
        this.x = x;
        this.y = y;
        this.xSize = xSize;
        this.ySize = ySize;
    }

    @Override
    public void draw(Graphics g, double delta) {
        g.fillRect((int) x, (int) y, (int) xSize, (int) ySize);
        g.drawString("Entity on " + x + y, (int) x, (int) y);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getxSize() {
        return xSize;
    }

    @Override
    public void setxSize(double xSize) {
        this.xSize = xSize;
    }

    @Override
    public double getySize() {
        return ySize;
    }

    @Override
    public void setySize(double ySize) {
        this.ySize = ySize;
    }

    public boolean isCollides() {
        return collides;
    }

    public void setCollides(boolean collides) {
        this.collides = collides;
    }
}
