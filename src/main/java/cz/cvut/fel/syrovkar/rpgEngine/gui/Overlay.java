package cz.cvut.fel.syrovkar.rpgEngine.gui;

import java.awt.*;

/**
 * Overlay wrapper for displaying stuff on screen on top of everything else.
 *
 * Created by Karel on 18. 5. 2015.
 */
public interface Overlay {

    /**
     * @return If the game should be paused if this overlay is displayed
     */
    boolean shouldTheGameBePaused();

    /**
     * @param g     Graphics to draw on
     * @param delta Time interval between frames of the Game
     */
    void draw(Graphics g, double delta);

    /**
     * @return If this overlay needs some inputs from PlayerInteraction
     */
    boolean listensToInput();

    /**
     * @return True if this overlay is displayed, false otherwise
     */
    boolean isOpened();

}
