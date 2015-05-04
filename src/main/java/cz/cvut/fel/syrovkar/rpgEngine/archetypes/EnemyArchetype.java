package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Logger;

/**
 * Adds drops into BasicArchetype
 *
 * Created by Karel on 28. 4. 2015.
 */
public class EnemyArchetype extends BasicArchetype {

    private static final Logger LOG = Logger.getLogger(EnemyArchetype.class.getName());

    ArrayList<EnemyDrop> drops;

    public EnemyArchetype(String name, String id, Image texture, HashSet<Attribute> attributes, ArrayList<EnemyDrop> dropList) {
        super(name, id, texture, attributes);

        drops = dropList;

        LOG.finer("Created new EnemyArchetype: " + this.toString());
    }

    @Override
    public String toString() {
        return "EnemyArchetype{" +
                "drops=" + drops +
                super.toString() +
                '}';
    }
}
