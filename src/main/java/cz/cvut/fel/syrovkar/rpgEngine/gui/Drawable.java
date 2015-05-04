package cz.cvut.fel.syrovkar.rpgEngine.gui;

import java.awt.*;

/**
 * Specifies if an object can be drawn on Canvas.
 *
 * Created by Karel on 1. 4. 2015.
 */
public interface Drawable {

    /**
     * What do you want to draw?
     *
     * @param g     Graphics to draw on
     * @param delta Time delay between frames
     */
    void draw(Graphics g, double delta);

    /**
     * @return X coordinate of Drawable object
     */
    double getX();

    /**
     * @return Y coordinate of Drawable object
     */
    double getY();

    /**
     * Set new X coordinate
     *
     * @param x New X
     */
    void setX(double x);

    /**
     * Set new Y coordinate
     *
     * @param y New Y
     */
    void setY(double y);

    /**
     * @return Size on X axis.
     */
    double getxSize();

    /**
     * Set size on X axis.
     *
     * @param xSize New size on X axis
     */
    void setxSize(double xSize);

    /**
     * @return Size on Y axis
     */
    double getySize();

    /**
     * set size on Y axis
     *
     * @param ySize new size on y  axis
     */
    void setySize(double ySize);

    /**
     * @return true if it has a texture, false otherwise
     */
     boolean hasTexture();
}
