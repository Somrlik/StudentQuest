package cz.cvut.fel.syrovkar.studentRPG.utils;

import cz.cvut.fel.syrovkar.studentRPG.Attribute;

import java.util.List;

/**
 * Created by Karel on 24. 2. 2015.
 */
public class AttribHelper {

    public static Object getAttributeByName(CanHaveAttributes attributedObject, String name) {
        List<Attribute> attributeList = attributedObject.getAttributes();

        for (Attribute attribute : attributeList) {
            if (attribute.getName().equals(name)) {
                return attribute.getAttribute();
            }
        }
        return null;

    }

}
