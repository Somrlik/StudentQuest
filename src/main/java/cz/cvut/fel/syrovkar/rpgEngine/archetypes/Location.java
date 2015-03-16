package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

import cz.cvut.fel.syrovkar.rpgEngine.utils.AttribHelper;
import cz.cvut.fel.syrovkar.rpgEngine.utils.CanHaveAttributes;

import java.util.HashSet;

/**
 * Basic Location class.
 *
 * Created by Karel on 25. 2. 2015.
 */
public class Location implements CanHaveAttributes {

    String name;

    HashSet<Attribute> attributes;

    /**
     * Creates a new location.
     *
     * @param name name of location
     */
    public Location(String name) {
        this.name = name;
        this.attributes = new HashSet<Attribute>();
    }

    @Override
    public Object getValueByAttrName(String name) {
        return null;
    }

    @Override
    public HashSet<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public void addAttribute(String name, Object value) {
        AttribHelper.addAttribute(this, name, value);
    }

    @Override
    public void setValueByAttrName(String name, Object value) {
        AttribHelper.setValueByAttrName(this, name, value);
    }

    @Override
    public void removeAttribute(String name) {
        AttribHelper.removeAttribute(this, name);
    }

    @Override
    public boolean hasAttribute(String name) {
        return AttribHelper.hasAttribute(this, name);
    }
}
