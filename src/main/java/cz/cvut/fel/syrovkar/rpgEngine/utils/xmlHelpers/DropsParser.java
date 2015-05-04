package cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.EnemyDrop;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

/**
 * Wrapper for droppings.
 *
 * Created by Karel on 28. 4. 2015.
 */
public class DropsParser {

    /**
     * Parses Drops from NodeList of nodes.
     *
     * @param nodeList NodeList beginning with "&lt;drops&gt;"
     * @return ArrayList of parsed drops
     */
    public static ArrayList<EnemyDrop> parse(NodeList nodeList) {

        nodeList = nodeList.item(0).getChildNodes();

        ArrayList<EnemyDrop> enemyDrops = new ArrayList<EnemyDrop>();

        for (int temp = 0; temp < nodeList.getLength(); temp++) {

            Node nNode = nodeList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;

                enemyDrops.add(new EnemyDrop(Double.parseDouble(eElement.getElementsByTagName("probability").item(0).getTextContent()),
                        eElement.getElementsByTagName("id").item(0).getTextContent()));

            }
        }
        return enemyDrops;
    }


}
