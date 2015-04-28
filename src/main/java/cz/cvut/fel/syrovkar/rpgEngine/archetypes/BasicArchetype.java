package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

import cz.cvut.fel.syrovkar.rpgEngine.utils.AttribHelper;
import cz.cvut.fel.syrovkar.rpgEngine.utils.CanHaveAttributes;

import java.awt.*;
import java.util.HashSet;

/**
 * Created by Karel on 28. 4. 2015.
 */
public class BasicArchetype implements CanHaveAttributes {

    private String name;
    private String id;
    private Image texture;

    private HashSet<Attribute> attributes;

    public BasicArchetype(String name, String id, Image texture, HashSet<Attribute> attributes) {
        this.name = name;
        this.id = id;
        this.texture = texture;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Image getTexture() {
        return texture;
    }

    public void setTexture(Image texture) {
        this.texture = texture;
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


}
