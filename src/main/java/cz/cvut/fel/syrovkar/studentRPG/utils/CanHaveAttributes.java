package cz.cvut.fel.syrovkar.studentRPG.utils;

import cz.cvut.fel.syrovkar.studentRPG.archetypes.Attribute;

import java.util.HashSet;

/**
 * When an actor implements this interface, it receives an ability to have attributes.
 *
 * Created by Karel on 24. 2. 2015.
 */
public interface CanHaveAttributes {

    /**
     * Used only by engine. Do not use.
     *
     * @return Do not use
     */
    public HashSet<Attribute> getAttributes();

    /**
     * Gets value of attribute by given name
     *
     * @param name Name of attribute
     * @return Value fo attribute
     */
    public Object getAttributeByName(String name);

    /**
     * Adds an attribute
     *
     * @param name  Name of attribute
     * @param value value of attribute
     */
    public void addAttribute(String name, Object value);

}