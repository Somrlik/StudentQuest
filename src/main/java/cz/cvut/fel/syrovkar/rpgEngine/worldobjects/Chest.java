package cz.cvut.fel.syrovkar.rpgEngine.worldobjects;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.ItemArchetype;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Karel on 19. 5. 2015.
 */
public class Chest extends InteractibleEntity {

    private static final Logger LOG = Logger.getLogger(Chest.class.getName());

    private List<ItemArchetype> items;

    private String key;

    private boolean wasOpened = false;

    public Chest(String name, String id, double x, double y, double xSize, double ySize, List<ItemArchetype> items, String keyId) {
        super(name, id, x, y, xSize, ySize);
        this.items = items;
        this.key = keyId;
    }

    @Override
    public void interact(Player player) {
        if (!wasOpened && player.isInInventory(key)) {
            open(player);
        }
    }

    private void open(Player player) {
        for (ItemArchetype ia : items) {
            player.addToInventory(ia);
        }
        wasOpened = true;
        items.clear();
    }

}
