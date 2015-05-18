package cz.cvut.fel.syrovkar.rpgEngine.tests;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Attribute;
import junit.framework.TestCase;

public class AttributeTest extends TestCase {

    public void testGetValue() throws Exception {
        Attribute atr = new Attribute("Test", "");
        assertEquals(0, atr.getValue());
    }

    public void testGetName() throws Exception {
        Attribute atr = new Attribute("Test", "");
        assertEquals("Test", atr.getName());
    }

    public void testEquals() throws Exception {
        Attribute atr1 = new Attribute("Test", "");
        Attribute atr2 = new Attribute("Test", "");

        assertEquals(atr1, atr2);

    }
}