package cz.cvut.fel.syrovkar.rpgEngine.worldobjects;

import cz.cvut.fel.syrovkar.rpgEngine.Game;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Attribute;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.ItemArchetype;
import cz.cvut.fel.syrovkar.rpgEngine.init.GameRegistry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Basic Item class.
 *
 * Created by Karel on 23. 2. 2015.
 */
public class Item extends Entity {

    private static final Logger LOG = Logger.getLogger(Item.class.getName());

    public Item(ItemArchetype archetype, int x, int y, int xSize, int ySize) {
        super(archetype.getName(), archetype.getId(), x, y, xSize, ySize);

        this.setTexture(archetype.getTexture());


        for (Attribute a : archetype.getAttributes()) {
            this.addAttribute(a.getName(), a.getValue());
        }
    }

    public synchronized void destroy() {
        List<Item> secondList = new ArrayList<Item>();
        for (Iterator<Item> iterator = Game.currentLocation.getItems().iterator(); iterator.hasNext(); ) {
            Item item = iterator.next();
            if (item == this) {
                secondList.add(item);
            }
        }
        GameRegistry.itemsToDelete = secondList;
        /*
        for(Item i : Game.currentLocation.getItems()) {
            if (i == this) {
                Game.currentLocation.removeItem(i);
            }
        }
        */
    }
}
