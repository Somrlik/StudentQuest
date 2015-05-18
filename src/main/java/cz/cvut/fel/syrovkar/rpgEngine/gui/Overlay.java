package cz.cvut.fel.syrovkar.rpgEngine.gui;

import java.awt.*;

/**
 * Created by Karel on 18. 5. 2015.
 */
public interface Overlay {

    boolean shouldTheGameBePaused();

    void draw(Graphics g, double delta);

    boolean listensToInput();

    boolean isOpened();

}
