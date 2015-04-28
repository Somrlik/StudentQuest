package cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Attribute;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashSet;

/**
 * Created by Karel on 28. 4. 2015.
 */
public class AttributesParser {

    public static HashSet<Attribute> parse(NodeList nodeList) {

        nodeList = nodeList.item(0).getChildNodes();

        HashSet<Attribute> attributes = new HashSet<Attribute>();

        for (int temp = 0; temp < nodeList.getLength(); temp++) {

            Node nNode = nodeList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;

                attributes.add(new Attribute(eElement.getElementsByTagName("name").item(0).getTextContent(), eElement.getElementsByTagName("value").item(0).getTextContent()));

            }
        }
        return attributes;
    }
}
