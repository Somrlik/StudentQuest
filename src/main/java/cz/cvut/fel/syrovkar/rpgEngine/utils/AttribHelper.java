package cz.cvut.fel.syrovkar.rpgEngine.utils;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Attribute;

import java.util.HashSet;
import java.util.logging.Logger;

/**
 * Helper for extracting and inserting attributes to actors.
 *
 * Created by Karel on 24. 2. 2015.
 */
public class AttribHelper {

    private static final Logger LOG = Logger.getLogger(AttribHelper.class.getName());

    /**
     * Helper for getting attributes
     *
     * @param attributedObject An Object that can have attributes
     * @param name             Name of attribute
     * @return Value of attribute
     */
    public static String getValueByAttrName(CanHaveAttributes attributedObject, String name) {
        HashSet<Attribute> attributeList = attributedObject.getAttributes();

        for (Attribute attribute : attributeList) {
            if (attribute.getName().equals(name)) {
                return attribute.getValue();
            }
        }
        return null;
    }

    /**
     * Sets attribute of given name.
     *
     * @param attributedObject An Object that can have attributes
     * @param name             Name of attribute
     * @param value            Value to set to attribute
     */
    public static void setValueByAttrName(CanHaveAttributes attributedObject, String name, String value) {
        HashSet<Attribute> attributes = attributedObject.getAttributes();

        for (Attribute attribute : attributes) {
            if (attribute.getName().equals(name)) {
                attribute.setValue(value);
                return;
            }
        }

        LoggingHelper.LOGGER.warning("Attribute with name '" + name + "' cannot be changed, because it does not exist.");
    }

    /**
     * Helper for adding attributes
     *
     * @param attributableObject An Object that can have attributes
     * @param name               Name of attribute
     * @param value              Value of attribute
     */
    public static void addAttribute(CanHaveAttributes attributableObject, String name, String value) {

        HashSet<Attribute> attributeList = attributableObject.getAttributes();

        if (!attributeList.add(new Attribute(name, value)))
            LoggingHelper.LOGGER.warning("Attribute of same name '" + name + "' already exists. Ignoring new attribute.");

    }

    /**
     * Helper for removing attributes
     *
     * @param attributableObject An Object that can have attributes
     * @param name               Name of attribute
     */
    public static void removeAttribute(CanHaveAttributes attributableObject, String name) {
        HashSet<Attribute> attributes = attributableObject.getAttributes();

        attributes.remove(new Attribute(name, ""));
    }


    /**
     * Helper for checking existence of an attribute
     *
     * @param attributableObject An object that can have attributes
     * @param name               Name of attribute
     * @return true if the attribute exists, false otherwise
     */
    public static boolean hasAttribute(CanHaveAttributes attributableObject, String name) {
        HashSet<Attribute> attributes = attributableObject.getAttributes();

        return attributes.contains(new Attribute(name, ""));
    }
}
