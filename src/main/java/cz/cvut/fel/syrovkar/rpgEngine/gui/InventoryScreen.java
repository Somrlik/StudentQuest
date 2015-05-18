package cz.cvut.fel.syrovkar.rpgEngine.gui;

import java.awt.*;
import java.util.logging.Logger;

/**
 * Displays inventory screen for player.
 *
 * Created by Karel on 7. 5. 2015.
 */
public class InventoryScreen implements Overlay {

    private static final Logger LOG = Logger.getLogger(InventoryScreen.class.getName());

    @Override
    public boolean shouldTheGameBePaused() {
        return true;
    }

    @Override
    public void draw(Graphics g, double delta) {

    }

    @Override
    public boolean listensToInput() {
        return true;
    }

    @Override
    public boolean isOpened() {
        return false;
    }
}
