package cz.cvut.fel.syrovkar.rpgEngine.utils;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Attribute;

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
     * Gets value of attribute of given name
     *
     * @param name Name of attribute
     * @return Value fo attribute
     */
    public Object getValueByAttrName(String name);

    /**
     * Sets value of attribute of given name.
     *
     * @param name  Name of attribute
     * @param value Value of attribute
     */
    public void setValueByAttrName(String name, Object value);

    /**
     * Adds an attribute
     *
     * @param name  Name of attribute
     * @param value value of attribute
     */
    public void addAttribute(String name, Object value);

    /**
     * Removes attribute of given name.
     *
     * @param name Name of attribute
     */
    public void removeAttribute(String name);

    /**
     * Finds out, if an actor has attribute of given name.
     *
     * @param name Name of attribute
     * @return true if attribute is present, false otherwise
     */
    public boolean hasAttribute(String name);

}