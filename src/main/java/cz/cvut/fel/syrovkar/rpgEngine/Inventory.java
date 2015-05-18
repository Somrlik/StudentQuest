package cz.cvut.fel.syrovkar.rpgEngine;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.ItemArchetype;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Inventory of the player. Stores ItemArchetypes.
 *
 * Created by Karel on 7. 5. 2015.
 */
public class Inventory {

    private static final Logger LOG = Logger.getLogger(Inventory.class.getName());

    ArrayList<ItemArchetype> items;

    private int size = 0;

    public Inventory() {
        this.items = new ArrayList<ItemArchetype>();
    }

    /**
     * Adds Item to the Inventory
     *
     * @param i ItemArchetype to be added
     */
    public void addItem(ItemArchetype i) {
        if (i != null) {
            items.add(i);
            size++;
            LOG.finer("Added item into inventory " + i.toString());
            return;
        }
        LOG.severe("Failed to add item into inventory.");
    }

    /**
     * Removes item from the inventory
     *
     * @param i Item to remove
     */
    public void removeItem(ItemArchetype i) {
        if (i != null) {
            items.remove(i);
        }
    }

    /**
     * @param itemId Item id of ItemArchetype to check
     * @return True if Item is in inventory, false otherwise
     */
    public boolean isInInventory(String itemId) {
        for (ItemArchetype i : items) {
            if (i.getId().equals(itemId)) {
                return true;
            }
        }
        return false;
    }

    public List<ItemArchetype> getItemArchetypes() {
        return items;
    }
}
