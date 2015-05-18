package cz.cvut.fel.syrovkar.rpgEngine.gui;

import java.awt.*;
import java.util.logging.Logger;

/**
 * FPS meter overlay
 * <p/>
 * Created by Karel on 18. 5. 2015.
 */
public class FPSMeter implements Overlay {

    private static final Logger LOG = Logger.getLogger(FPSMeter.class.getName());

    @Override
    public boolean shouldTheGameBePaused() {
        return false;
    }

    @Override
    public void draw(Graphics g, double delta) {
        g.setColor(Color.black);
        g.drawString("FPS: " + Double.toString(1 / delta), 10, 10);
    }

    @Override
    public boolean listensToInput() {
        return false;
    }

    @Override
    public boolean isOpened() {
        return true;
    }
}
