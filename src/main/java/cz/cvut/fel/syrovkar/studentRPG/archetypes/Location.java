package cz.cvut.fel.syrovkar.studentRPG.archetypes;

import cz.cvut.fel.syrovkar.studentRPG.utils.AttribHelper;
import cz.cvut.fel.syrovkar.studentRPG.utils.CanHaveAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karel on 25. 2. 2015.
 */
public class Location implements CanHaveAttributes {

    String name;

    List<Attribute> attributes;

    public Location(String name) {
        this.name = name;
        this.attributes = new ArrayList<Attribute>();
    }

    @Override
    public Object getAttributeByName(String name) {
        return null;
    }

    @Override
    public void setAttributes(List<Attribute> attributes) {

    }

    @Override
    public List<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public void addAttribute(String name, Object value) {
        AttribHelper.addAttribute(this, name, value);
    }
}
