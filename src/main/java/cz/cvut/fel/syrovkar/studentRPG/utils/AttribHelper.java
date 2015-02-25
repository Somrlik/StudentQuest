package cz.cvut.fel.syrovkar.studentRPG.utils;

import cz.cvut.fel.syrovkar.studentRPG.archetypes.Attribute;

import java.util.HashSet;

/**
 * Created by Karel on 24. 2. 2015.
 */
public class AttribHelper {

    /**
     * Helper for getting attributes
     *
     * @param attributedObject An Object that can have attributes
     * @param name             Name of attribute
     * @return Value of attribute
     */
    public static Object getAttributeByName(CanHaveAttributes attributedObject, String name) {
        HashSet<Attribute> attributeList = attributedObject.getAttributes();

        for (Attribute attribute : attributeList) {
            if (attribute.getName().equals(name)) {
                return attribute.getValue();
            }
        }
        return null;

    }

    /**
     * Helper for adding attributes
     *
     * @param attributableObject An Object that can have attributes
     * @param name               Name of attribute
     * @param value              value fo attribute
     */
    public static void addAttribute(CanHaveAttributes attributableObject, String name, Object value) {

        HashSet<Attribute> attributeList = attributableObject.getAttributes();

        if (!attributeList.add(new Attribute(name, value)))
            LoggingHelper.warning("Attribute of same name '" + name + "' already exists. Ignoring new attribute.");

    }
}
