package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

import cz.cvut.fel.syrovkar.rpgEngine.gui.Drawable;

import java.awt.*;

/**
 * Created by Karel on 24. 3. 2015.
 */
public class Entity implements Drawable {

    protected double x;
    protected double y;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return (int) x;
    }

    @Override

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return (int) y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void draw(Graphics g, double delta) {
        g.drawString("Entity on " + x + y, (int) x, (int) y);
    }
}
