package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

import java.awt.*;
import java.util.HashSet;

/**
 * Extends BasicArchetype for Items.
 *
 * Created by Karel on 28. 4. 2015.
 */
public class ItemArchetype extends BasicArchetype {

    public ItemArchetype(String name, String id, Image texture, HashSet<Attribute> attributes) {
        super(name, id, texture, attributes);
    }
}
