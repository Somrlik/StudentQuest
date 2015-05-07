package cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers;

import cz.cvut.fel.syrovkar.rpgEngine.Game;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Location;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.logging.Logger;

/**
 * Parses player.xml
 * <p/>
 * Created by Karel on 28. 4. 2015.
 */
public class PlayerParser {

    private static final Logger LOG = Logger.getLogger(PlayerParser.class.getName());

    /**
     * Parses Player .xml file.
     *
     * @param file Usually player.xml
     */
    public static void parse(File file) {

        LOG.finest("Parsing Payer file " + file.getName());

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            String spawn = "";
            int posX = -1, posY = -1;

            NodeList nl = doc.getElementsByTagName("spawn");
            if (nl.item(0) != null) spawn = nl.item(0).getTextContent();

            nl = doc.getElementsByTagName("pos-x");
            if (nl.item(0) != null) posX = Integer.parseInt(nl.item(0).getTextContent());

            nl = doc.getElementsByTagName("pos-y");
            if (nl.item(0) != null) posY = Integer.parseInt(nl.item(0).getTextContent());

            Game.gameRegistry.getPlayer().setX(posX);
            Game.gameRegistry.getPlayer().setY(posY);

            Location spawnLocation = Game.gameRegistry.getWorld().getLocationWithId(spawn);
            if (spawnLocation == null) {
                LOG.severe("Unable to set player's spawn point... Trying to exit...");
                return;
            }
            spawnLocation.setIsPlayerHere(true);
            Game.currentLocation = spawnLocation;

        } catch (Exception e) {
            LOG.severe("Parsing of " + file.getName() + " failed.");
            e.printStackTrace();
        }
    }

}
