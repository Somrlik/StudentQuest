package cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers;

import cz.cvut.fel.syrovkar.rpgEngine.Game;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Attribute;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Location;
import cz.cvut.fel.syrovkar.rpgEngine.init.GameRegistry;
import cz.cvut.fel.syrovkar.rpgEngine.utils.FileHelper;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.util.HashSet;
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
    public static void parse(File file, GameRegistry gameRegistry) {

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

            HashSet<Attribute> attributes = null;
            nl = doc.getElementsByTagName("attributes");
            if (nl.item(0) != null) attributes = AttributesParser.parse(nl);

            String textureURL = "";
            nl = doc.getElementsByTagName("texture");
            if (nl.item(0) != null) textureURL = nl.item(0).getTextContent();

            Image texture = null;
            if (!textureURL.isEmpty()) {
                File textureFile = FileHelper.getFileFromURI("textures/" + textureURL);
                if (textureFile == null) {
                    LOG.severe("Error loading texture for player from file " + textureURL);
                } else {
                    LOG.finest("Loaded texture for player from file " + textureURL);
                    texture = ImageIO.read(textureFile);
                }
            }

            gameRegistry.getPlayer().setTexture(texture);
            gameRegistry.getPlayer().setX(posX);
            gameRegistry.getPlayer().setY(posY);

            if (attributes != null) {
                for (Attribute a : attributes) {
                    gameRegistry.getPlayer().addAttribute(a.getName(), a.getValue());
                }
            }

            Location spawnLocation = gameRegistry.getWorld().getLocationWithId(spawn);
            if (spawnLocation == null) {
                LOG.severe("Unable to set player's spawn point... Trying to exit...");
                Game.exitFail();
                return;
            }
            spawnLocation.setIsPlayerHere(true);
            Game.currentLocation = spawnLocation;
            gameRegistry.getWorld().setCurrentI(spawnLocation.getI());
            gameRegistry.getWorld().setCurrentJ(spawnLocation.getJ());

        } catch (Exception e) {
            LOG.severe("Parsing of " + file.getName() + " failed.");
            e.printStackTrace();
        }
    }

}
