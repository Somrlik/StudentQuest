package cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers;

import cz.cvut.fel.syrovkar.rpgEngine.Game;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Location;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Parses player.xml
 * <p/>
 * Created by Karel on 28. 4. 2015.
 */
public class PlayerParser {

    /**
     * Parses Player .xml file.
     *
     * @param file Usually player.xml
     */
    public static void parse(File file) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            String spawn = "";
            int posX = -1, posY = -1;

            NodeList nl = doc.getElementsByTagName("spawn");
            if (nl != null) spawn = nl.item(0).getTextContent();

            nl = doc.getElementsByTagName("pos-x");
            if (nl != null) posX = Integer.parseInt(nl.item(0).getTextContent());

            nl = doc.getElementsByTagName("pos-y");
            if (nl != null) posY = Integer.parseInt(nl.item(0).getTextContent());

            Game.gameRegistry.getPlayer().setX(posX);
            Game.gameRegistry.getPlayer().setY(posY);

            Location spawnLocation = Game.gameRegistry.getWorld().getLocationWithId(spawn);
            if (spawnLocation == null) {
                throw new IllegalStateException("Wrong spawn point in player.xml");
            }
            spawnLocation.setIsPlayerHere(true);
            Game.currentLocation = spawnLocation;

        } catch (Exception e) {
            System.out.println("Parsing of " + file.getName() + " failed.");
            e.printStackTrace();
        }
    }

}
