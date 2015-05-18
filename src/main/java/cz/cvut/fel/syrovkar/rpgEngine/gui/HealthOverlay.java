package cz.cvut.fel.syrovkar.rpgEngine.gui;

import cz.cvut.fel.syrovkar.rpgEngine.Game;

import java.awt.*;
import java.util.logging.Logger;

/**
 * Draws health on the screen.
 *
 * Created by Karel on 18. 5. 2015.
 */
public class HealthOverlay implements Overlay {

    private static final Logger LOG = Logger.getLogger(HealthOverlay.class.getName());

    @Override
    public boolean shouldTheGameBePaused() {
        return false;
    }

    @Override
    public void draw(Graphics g, double delta) {
        String maxHealth = Game.gameRegistry.getPlayer().getValueByAttrName("Max Health");
        String currentHealth = Game.gameRegistry.getPlayer().getValueByAttrName("Health");
        double percent = Double.parseDouble(currentHealth) / Double.parseDouble(maxHealth);

        g.setColor(Color.black);
        g.fillRect(20, 20, 110, 30);
        g.setColor(Color.red);
        g.fillRect(25, 25, (int) percent * 100, 20);

    }

    @Override
    public boolean listenToInput() {
        return false;
    }

    @Override
    public boolean isOpened() {
        return true;
    }
}
