package cz.cvut.fel.syrovkar.studentRPG.utils;

import cz.cvut.fel.syrovkar.studentRPG.Attribute;

import java.util.List;

/**
 * Created by Karel on 24. 2. 2015.
 */
public interface CanHaveAttributes {

    public List<Attribute> getAttributes();

    public Object getAttributeByName(String name);

    public void setAttributes(List<Attribute> attributes);

}