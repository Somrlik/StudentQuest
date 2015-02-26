package cz.cvut.fel.syrovkar.studentRPG.tests;

import cz.cvut.fel.syrovkar.studentRPG.archetypes.Attribute;
import junit.framework.TestCase;

public class AttributeTest extends TestCase {

    public void testGetValue() throws Exception {
        Attribute atr = new Attribute("Test", 0);
        assertEquals(0, atr.getValue());
    }

    public void testGetName() throws Exception {
        Attribute atr = new Attribute("Test", 0);
        assertEquals("Test", atr.getName());
    }

    public void testEquals() throws Exception {
        Attribute atr1 = new Attribute("Test", 0);
        Attribute atr2 = new Attribute("Test", 20);

        assertEquals(atr1, atr2);

    }
}