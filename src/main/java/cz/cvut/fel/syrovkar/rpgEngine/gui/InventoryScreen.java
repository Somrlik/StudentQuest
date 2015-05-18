package cz.cvut.fel.syrovkar.rpgEngine.gui;

import cz.cvut.fel.syrovkar.rpgEngine.Game;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Attribute;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.ItemArchetype;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Displays inventory screen for player.
 *
 * Created by Karel on 7. 5. 2015.
 */
public class InventoryScreen implements Overlay {

    private static final Logger LOG = Logger.getLogger(InventoryScreen.class.getName());

    private boolean isOpen = false;

    private Image playerIcon = null;

    private Map<String, Image> mapOfItemIcons = null;

    @Override
    public boolean shouldTheGameBePaused() {
        return true;
    }

    @Override
    public void draw(Graphics g, double delta) {
        g.setColor(Color.gray);
        g.fillRect(100, 100, 600, 400);

        g.setColor(Color.white);
        g.drawString(Game.gameRegistry.getPlayer().getName() + "'s inventory", 120, 120);
        g.drawImage(playerIcon, 140, 140, 120, 120, Color.black, null);

        //g.setColor(Color.white);
        g.drawRect(320, 120, 360, 160);

        int i = 1;
        for (Attribute a : Game.gameRegistry.getPlayer().getAttributes()) {
            g.drawString(a.getName() + ": " + a.getValue(), 340, 120 + (20 * i++));
        }

        i = 1;

        for (String key : mapOfItemIcons.keySet()) {
            g.drawImage(mapOfItemIcons.get(key), 20 + 100 * i, 320, null);
            g.drawString(Game.gameRegistry.getItemArchetypeById(key).getName(), 120 * i, 320);
            int j = 1;
            for (Attribute a : Game.gameRegistry.getItemArchetypeById(key).getAttributes()) {
                g.drawString(a.getName() + ": " + a.getValue(), 20 + (100 * i), 420 + (20 * j++));
            }
            i++;
        }

    }

    public void open() {
        LOG.fine("Opened inventory screen");
        playerIcon = Game.gameRegistry.getPlayer().getTexture().getScaledInstance(120, 120, Image.SCALE_FAST);

        mapOfItemIcons = new HashMap<String, Image>();

        Image img = null;

        for (ItemArchetype ia : Game.gameRegistry.getPlayer().getInventory().getItemArchetypes()) {
            img = ia.getTexture().getScaledInstance(100, 100, Image.SCALE_FAST);

            mapOfItemIcons.put(ia.getId(), img);

        }

        isOpen = true;
        Game.pause();
    }

    public void close() {
        LOG.fine("Closed inventory screen");
        isOpen = false;
        Game.unpause();
    }

    @Override
    public boolean listenToInput() {

        if (PlayerInteraction.isInventoryPressed && !isOpen) {
            open();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (PlayerInteraction.isInventoryPressed && isOpen) {
            close();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    @Override
    public boolean isOpened() {
        return isOpen;
    }
}
