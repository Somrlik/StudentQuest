package cz.cvut.fel.syrovkar.rpgEngine.worldobjects;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Attribute;

import java.util.HashSet;
import java.util.logging.Logger;

/**
 * Basic character class.
 *
 * Created by Karel on 23. 2. 2015.
 */
public abstract class Character extends LivingEntity {

    private static final Logger LOG = Logger.getLogger(Character.class.getName());

    private String name;

    private HashSet<Attribute> attributes;

    /**
     * Creates a new Character
     *
     * @param name Name of character
     */
    public Character(String name, String id, int x, int y, int xSize, int ySize) {
        super(name, id, x, y, xSize, ySize);
        this.attributes = new HashSet<Attribute>();
    }

    /**
     * @return Name of character
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new name for character
     *
     * @param name New name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", attributes=" + attributes.toString() +
                '}';
    }
}
