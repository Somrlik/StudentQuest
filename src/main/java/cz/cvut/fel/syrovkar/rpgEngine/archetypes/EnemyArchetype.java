package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

import java.awt.*;
import java.util.HashSet;

/**
 * Created by Karel on 28. 4. 2015.
 */
public class EnemyArchetype extends BasicArchetype {

    public EnemyArchetype(String name, String id, Image texture, HashSet<Attribute> attributes) {
        super(name, id, texture, attributes);
    }
}
