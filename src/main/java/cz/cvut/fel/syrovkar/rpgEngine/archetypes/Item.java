package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

import cz.cvut.fel.syrovkar.rpgEngine.utils.AttribHelper;
import cz.cvut.fel.syrovkar.rpgEngine.utils.CanHaveAttributes;

import java.util.HashSet;

/**
 * Basic Item class.
 *
 * Created by Karel on 23. 2. 2015.
 */
public class Item extends Entity implements CanHaveAttributes {

    private String name;

    private HashSet<Attribute> attributes;

    public Item(String name, int x, int y, int xSize, int ySize) {
        super(x, y, xSize, ySize);
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
    public Object getValueByAttrName(String name) {
        return AttribHelper.getValueByAttrName(this, name);
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

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", attributes=" + attributes.toString() +
                '}';
    }
}
