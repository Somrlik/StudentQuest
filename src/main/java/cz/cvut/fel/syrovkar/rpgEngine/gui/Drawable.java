package cz.cvut.fel.syrovkar.rpgEngine.gui;

import java.awt.*;

/**
 * Created by Karel on 1. 4. 2015.
 */
public interface Drawable {

    public void draw(Graphics g, double delta);

    public int getX();

    public void setX(int x);

    public int getY();

    public void setY(int y);

}
