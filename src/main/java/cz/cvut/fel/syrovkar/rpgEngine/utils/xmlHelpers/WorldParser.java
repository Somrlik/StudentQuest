package cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers;

import cz.cvut.fel.syrovkar.rpgEngine.Game;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.WorldMap;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by Karel on 28. 4. 2015.
 */
public class WorldParser {

    public static void parse(File file) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = builder.parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();

        int i = 0, j = 0;

        NodeList nl = doc.getElementsByTagName("world-x");
        if (nl != null) i = Integer.parseInt(nl.item(0).getTextContent());

        nl = doc.getElementsByTagName("world-y");
        if (nl != null) j = Integer.parseInt(nl.item(0).getTextContent());

        WorldMap wm = new WorldMap(i * j);

        System.out.println("World has size of " + i + "x" + j);

        Game.gameRegistry.setWorld(wm);

    }

}
