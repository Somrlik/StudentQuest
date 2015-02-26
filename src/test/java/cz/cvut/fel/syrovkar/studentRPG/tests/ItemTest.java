package cz.cvut.fel.syrovkar.studentRPG.tests;

import cz.cvut.fel.syrovkar.studentRPG.archetypes.Attribute;
import cz.cvut.fel.syrovkar.studentRPG.archetypes.Item;
import junit.framework.TestCase;

import java.util.HashSet;

public class ItemTest extends TestCase {

    @SuppressWarnings("AssertEqualsBetweenInconvertibleTypes")
    public void testGetValueByAttrName() throws Exception {
        Item item = new Item("Item");
        item.addAttribute("Test", 0);

        assertEquals(item.getValueByAttrName("Test"), 0);
    }

    @SuppressWarnings("AssertEqualsBetweenInconvertibleTypes")
    public void testSetValueByAttrName() throws Exception {
        Item item = new Item("Test");
        item.addAttribute("Test", 0);

        item.setValueByAttrName("Test", 1);

        assertEquals(item.getValueByAttrName("Test"), 1);

    }

    public void testAddAttribute() throws Exception {
        Item item = new Item("Test Item");
        item.addAttribute("Test", 0);

        HashSet<Attribute> attributes = item.getAttributes();
        assertTrue(attributes.contains(new Attribute("Test", 0)));
    }

    public void testRemoveAttribute() throws Exception {
        Item item = new Item("Test");
        item.addAttribute("Test", 0);
        item.removeAttribute("Test");

        assertTrue(!(item.hasAttribute("Test")));
    }

    public void testHasAttribute() throws Exception {
        Item item = new Item("Test");

        item.addAttribute("Test", 0);

        assertTrue(item.hasAttribute("Test"));
    }
}