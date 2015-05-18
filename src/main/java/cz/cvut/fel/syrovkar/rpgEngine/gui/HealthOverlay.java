package cz.cvut.fel.syrovkar.rpgEngine.gui;

import cz.cvut.fel.syrovkar.rpgEngine.Game;

import java.awt.*;
import java.util.logging.Logger;

/**
 * Created by Karel on 18. 5. 2015.
 */
public class HealthOverlay implements Overlay {

    private static final Logger LOG = Logger.getLogger(HealthOverlay.class.getName());

    @Override
    public boolean shouldTheGameBePaused() {
        return true;
    }

    @Override
    public void draw(Graphics g, double delta) {
        Game.gameRegistry.getPlayer().getValueByAttrName("Max Health");
    }

    @Override
    public boolean listensToInput() {
        return false;
    }

    @Override
    public boolean isOpened() {
        return false;
    }
}
