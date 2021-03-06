package cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Attribute;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashSet;
import java.util.logging.Logger;

/**
 * Parses attributes from NodeList.
 *
 * Created by Karel on 28. 4. 2015.
 */
public class AttributesParser {

    private static final Logger LOG = Logger.getLogger(AttributesParser.class.getName());

    /**
     * Parses Attributes from NodeList of nodes.
     *
     * @param nodeList NodeList beginning with "&lt;attributes&gt;"
     * @return HashSet of attributes parsed
     */
    public static HashSet<Attribute> parse(NodeList nodeList) {

        LOG.finer("Parsing attributes...");

        nodeList = nodeList.item(0).getChildNodes();

        HashSet<Attribute> attributes = new HashSet<Attribute>();

        for (int temp = 0; temp < nodeList.getLength(); temp++) {

            Node nNode = nodeList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;

                attributes.add(new Attribute(eElement.getElementsByTagName("name").item(0).getTextContent(), eElement.getElementsByTagName("value").item(0).getTextContent()));

            }
        }

        LOG.finest("Added attributes " + attributes.toString());

        return attributes;
    }
}
