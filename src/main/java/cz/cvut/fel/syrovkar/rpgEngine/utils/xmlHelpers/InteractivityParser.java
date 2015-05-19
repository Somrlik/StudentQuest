package cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.ItemArchetype;
import cz.cvut.fel.syrovkar.rpgEngine.init.GameRegistry;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Chest;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Entity;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Created by Karel on 19. 5. 2015.
 */
public class InteractivityParser {

    private static final Logger LOG = Logger.getLogger(InteractivityParser.class.getName());

    public static Entity parse(NodeList nl, Entity e, GameRegistry gameRegistry) {

        Element node = (Element) nl.item(0);

        String type = node.getElementsByTagName("type").item(0).getTextContent();

        if ("chest".equals(type)) {
            String key = node.getElementsByTagName("key").item(0).getTextContent();

            NodeList nodeList = ((Element) node.getChildNodes()).getElementsByTagName("inventory").item(0).getChildNodes();

            ArrayList<ItemArchetype> archetypes = new ArrayList<ItemArchetype>();

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node nNode = nodeList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    archetypes.add(gameRegistry.getItemArchetypeById(eElement.getElementsByTagName("archetype").item(0).getTextContent()));
                }
            }

            return new Chest(e.getName(), e.getId(), e.getX(), e.getY(), e.getxSize(), e.getySize(), archetypes, key);
        } else return e;
    }
}
