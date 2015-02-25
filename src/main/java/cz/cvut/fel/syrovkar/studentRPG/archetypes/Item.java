package cz.cvut.fel.syrovkar.studentRPG.archetypes;

import cz.cvut.fel.syrovkar.studentRPG.utils.AttribHelper;
import cz.cvut.fel.syrovkar.studentRPG.utils.CanHaveAttributes;

import java.util.HashSet;

/**
 * Basic Item class.
 *
 * Created by Karel on 23. 2. 2015.
 */
public class Item implements CanHaveAttributes {

    private String name;

    private HashSet<Attribute> attributes;

    public Item(String name) {
        this.name = name;
        this.attributes = new HashSet<Attribute>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public Object getAttributeByName(String name) {
        return AttribHelper.getAttributeByName(this, name);
    }

    @Override
    public void addAttribute(String name, Object value) {
        AttribHelper.addAttribute(this, name, value);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", attributes=" + attributes.toString() +
                '}';
    }
}
