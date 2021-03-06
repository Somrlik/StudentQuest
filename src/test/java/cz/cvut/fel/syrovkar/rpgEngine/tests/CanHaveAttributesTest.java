package cz.cvut.fel.syrovkar.rpgEngine.tests;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Attribute;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.ItemArchetype;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Item;
import junit.framework.TestCase;

import java.util.HashSet;

public class CanHaveAttributesTest extends TestCase {

    Item item;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        Item item = new Item(new ItemArchetype("Item", "item", null, null), 0, 0, 20, 20);
    }

    @SuppressWarnings("AssertEqualsBetweenInconvertibleTypes")
    public void testGetValueByAttrName() throws Exception {

        item.addAttribute("Test", "");

        assertEquals(item.getValueByAttrName("Test"), 0);
    }

    @SuppressWarnings("AssertEqualsBetweenInconvertibleTypes")
    public void testSetValueByAttrName() throws Exception {
        item.addAttribute("Test", "");

        item.setValueByAttrName("Test", "s");

        assertEquals(item.getValueByAttrName("Test"), 1);

    }

    public void testAddAttribute() throws Exception {
        item.addAttribute("Test", "s");

        HashSet<Attribute> attributes = item.getAttributes();
        assertTrue(attributes.contains(new Attribute("Test", "")));
    }

    public void testRemoveAttribute() throws Exception {
        item.addAttribute("Test", "");
        item.removeAttribute("Test");

        assertTrue(!(item.hasAttribute("Test")));
    }

    public void testHasAttribute() throws Exception {
        item.addAttribute("Test", "");

        assertTrue(item.hasAttribute("Test"));
    }
}