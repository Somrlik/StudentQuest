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
import java.util.logging.Logger;

/**
 * Parses world.xml
 *
 * Created by Karel on 28. 4. 2015.
 */
public class WorldParser {

    private static final Logger LOG = Logger.getLogger(WorldParser.class.getName());

    /**
     * What world do we live in? Parses world.xml file.
     * <p/>
     * For more info on how to make such a xml file, see "examples/".
     *
     * @param file usually world.xml
     */
    public static void parse(File file) {

        LOG.finer("Parsing world: " + file.getName());

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOG.severe("Failed to load DocumentBuilder for " + file.getName());
            e.printStackTrace();
        }
        Document doc = null;
        try {
            doc = builder.parse(file);
            doc.getDocumentElement().normalize();
        } catch (SAXException e) {
            LOG.severe("Failed to parse " + file.getName() + " : " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            LOG.severe("Failed to parse " + file.getName() + " : " + e.getMessage());
            e.printStackTrace();
        }

        int i = -1, j = -1;

        NodeList nl = doc.getElementsByTagName("world-x");
        if (nl != null) i = Integer.parseInt(nl.item(0).getTextContent());

        nl = doc.getElementsByTagName("world-y");
        if (nl != null) j = Integer.parseInt(nl.item(0).getTextContent());

        LOG.finest("Parsed with i,j:" + i + "," + j);

        WorldMap wm = new WorldMap(i * j);

        Game.gameRegistry.setWorld(wm);

    }

}
