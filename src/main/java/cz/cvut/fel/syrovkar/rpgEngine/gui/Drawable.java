package cz.cvut.fel.syrovkar.rpgEngine.gui;

import java.awt.*;

/**
 * Created by Karel on 1. 4. 2015.
 */
public interface Drawable {

    public void draw(Graphics g, double delta);

    public double getX();

    public double getY();

    public void setX(double x);

    public void setY(double y);

    public double getxSize();

    public void setxSize(double xSize);

    public double getySize();

    public void setySize(double ySize);

    public boolean hasTexture();
}
