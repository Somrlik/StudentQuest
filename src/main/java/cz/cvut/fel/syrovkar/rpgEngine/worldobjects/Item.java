package cz.cvut.fel.syrovkar.rpgEngine.worldobjects;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Attribute;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.ItemArchetype;

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

}
