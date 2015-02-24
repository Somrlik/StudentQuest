package cz.cvut.fel.syrovkar.studentRPG;

import cz.cvut.fel.syrovkar.studentRPG.utils.AttribHelper;
import cz.cvut.fel.syrovkar.studentRPG.utils.CanHaveAttributes;

import java.util.List;

/**
 * Created by Karel on 23. 2. 2015.
 */
public class Item implements CanHaveAttributes {

    private String name;

    private List<Attribute> attributes;

    public Item(String name, List<Attribute> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public Object getAttributeByName(String name) {
        return AttribHelper.getAttributeByName(this, name);
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", attributes=" + attributes.toString() +
                '}';
    }
}
