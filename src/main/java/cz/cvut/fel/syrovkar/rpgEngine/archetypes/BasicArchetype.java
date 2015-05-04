package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

import cz.cvut.fel.syrovkar.rpgEngine.utils.AttribHelper;
import cz.cvut.fel.syrovkar.rpgEngine.utils.CanHaveAttributes;

import java.awt.*;
import java.util.HashSet;

/**
 * Basic archetype serves as a basic wrapper for each class of Enemy, Item or something else requiring archetypes.
 *
 * These archetypes are then stored in GameRegistry and later instanced during the game.
 *
 * BasicArchetype is defined by an unique id.
 * Created by Karel on 28. 4. 2015.
 */
public class BasicArchetype implements CanHaveAttributes {

    private String name;
    private String id;
    private Image texture;

    private HashSet<Attribute> attributes;

    /**
     * @param name       Just a name for debugging
     * @param id         Unique identification
     * @param texture    Accepts awt Image resource
     * @param attributes List of attributes
     */
    public BasicArchetype(String name, String id, Image texture, HashSet<Attribute> attributes) {
        this.name = name;
        this.id = id;
        this.texture = texture;
        this.attributes = attributes;
    }

    /**
     * Gets name of BasicArchetype
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of an archetype
     * @param name New name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets unique id of archetype
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the texture used
     * @return Used texture
     */
    public Image getTexture() {
        return texture;
    }

    /**
     * Sets texture for this archetype
     * @param texture New texture
     */
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

    @Override
    public String toString() {
        return "BasicArchetype{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", texture=" + texture +
                ", attributes=" + attributes +
                '}';
    }
}
