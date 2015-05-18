package cz.cvut.fel.syrovkar.rpgEngine;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.ItemArchetype;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by Karel on 7. 5. 2015.
 */
public class Inventory {

    private static final Logger LOG = Logger.getLogger(Inventory.class.getName());

    ArrayList<ItemArchetype> items;
    private int size = 0;

    public Inventory() {
        this.items = new ArrayList<ItemArchetype>();
    }

    public void addItem(ItemArchetype i) {
        if (i != null) {
            items.add(i);
            size++;
            LOG.finer("Added item into inventory " + i.toString());
            return;
        }
        LOG.severe("Failed to add item into inventory.");
    }

    public void removeItem(ItemArchetype i) {
        if (i != null) {
            items.remove(i);
        }
    }

    public boolean isInInventory(String itemId) {
        for (ItemArchetype i : items) {
            if (i.getId().equals(itemId)) {
                return true;
            }
        }
        return false;
    }
}
