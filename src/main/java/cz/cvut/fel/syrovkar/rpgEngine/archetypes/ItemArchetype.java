package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

import java.awt.*;
import java.util.HashSet;
import java.util.logging.Logger;

/**
 * Extends BasicArchetype for Items.
 *
 * Created by Karel on 28. 4. 2015.
 */
public class ItemArchetype extends BasicArchetype {

    private static final Logger LOG = Logger.getLogger(ItemArchetype.class.getName());

    public ItemArchetype(String name, String id, Image texture, HashSet<Attribute> attributes) {
        super(name, id, texture, attributes);

        LOG.finer("Created new ItemArchetype: " + this.toString());

    }

    @Override
    public String toString() {
        return "ItemArchetype{} " + super.toString();
    }
}
