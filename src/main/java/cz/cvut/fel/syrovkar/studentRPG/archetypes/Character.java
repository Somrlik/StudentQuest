package cz.cvut.fel.syrovkar.studentRPG.archetypes;

import cz.cvut.fel.syrovkar.studentRPG.utils.AttribHelper;
import cz.cvut.fel.syrovkar.studentRPG.utils.CanHaveAttributes;

import java.util.HashSet;

/**
 * Basic character class.
 *
 * Created by Karel on 23. 2. 2015.
 */
public abstract class Character implements CanHaveAttributes {
    private String name;

    private HashSet<Attribute> attributes;

    /**
     * Creates a new Character
     *
     * @param name Name of character
     */
    public Character(String name) {
        this.name = name;
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
    public HashSet<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public Object getValueByAttrName(String name) {
        return AttribHelper.getValueByAttrName(this, name);
    }

    @Override
    public void setValueByAttrName(String name, Object value) {
        AttribHelper.setValueByAttrName(this, name, value);
    }

    @Override
    public void addAttribute(String name, Object value) {
        AttribHelper.addAttribute(this, name, value);
    }

    @Override
    public void removeAttribute(String name) {
        AttribHelper.removeAttribute(this, name);
    }

    @Override
    public boolean hasAttribute(String name) {
        return AttribHelper.hasAttribute(this, name);
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", attributes=" + attributes.toString() +
                '}';
    }
}
