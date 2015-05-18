package cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.EnemyArchetype;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.ItemArchetype;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Location;
import cz.cvut.fel.syrovkar.rpgEngine.init.GameRegistry;
import cz.cvut.fel.syrovkar.rpgEngine.utils.FileHelper;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Enemy;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Entity;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Item;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.util.logging.Logger;

/**
 * Parses .xml files with locations.
 *
 * Created by Karel on 28. 4. 2015.
 */
public class LocationsParser {

    private static final Logger LOG = Logger.getLogger(LocationsParser.class.getName());

    /**
     * Parses .xml with Location.
     * <p/>
     * For more info on how to make such a xml file, see "examples/".
     *
     * @param file .xml file with Location
     */
    public static void parse(File file, GameRegistry gameRegistry) {
        try {

            LOG.finer("Parsing Location file " + file.getName());

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            String name = "", id = "";

            NodeList nl = doc.getElementsByTagName("name");
            if (nl.item(0) != null) name = nl.item(0).getTextContent();

            nl = doc.getElementsByTagName("id");
            if (nl.item(0) != null) id = nl.item(0).getTextContent();

            int mapX = -1, mapY = -1;

            nl = doc.getElementsByTagName("map-x");
            if (nl.item(0) != null) mapX = Integer.parseInt(nl.item(0).getTextContent());

            nl = doc.getElementsByTagName("map-y");
            if (nl.item(0) != null) mapY = Integer.parseInt(nl.item(0).getTextContent());

            Color clr = new Color(0xFFFFFF);
            nl = doc.getElementsByTagName("background");
            if (nl.item(0) != null) clr = new Color(Integer.decode(nl.item(0).getTextContent()));

            Location loc = new Location(name, id, mapX, mapY);

            loc.setBackground(clr);

            //* entities parsing

            LOG.finest("Parsing entities...");
            nl = doc.getElementsByTagName("entities");

            if (nl != null) {
                nl = nl.item(0).getChildNodes();

                for (int temp = 0; temp < nl.getLength(); temp++) {

                    Node nNode = nl.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode;

                        String entityName = eElement.getElementsByTagName("name").item(0).getTextContent();
                        String textureURL = eElement.getElementsByTagName("texture").item(0).getTextContent();
                        boolean collides = Boolean.parseBoolean(eElement.getElementsByTagName("collision").item(0).getTextContent());

                        int posX = Integer.parseInt(eElement.getElementsByTagName("pos-x").item(0).getTextContent());
                        int posY = Integer.parseInt(eElement.getElementsByTagName("pos-y").item(0).getTextContent());
                        int sizX = Integer.parseInt(eElement.getElementsByTagName("siz-x").item(0).getTextContent());
                        int sizY = Integer.parseInt(eElement.getElementsByTagName("siz-y").item(0).getTextContent());

                        Entity e = new Entity(entityName, entityName, posX, posY, sizX, sizY);

                        e.setCollides(collides);

                        // Texture loading
                        Image texture = null;
                        if (!textureURL.isEmpty()) {
                            File textureFile = FileHelper.getFileFromURI("textures/" + textureURL);
                            if (textureFile == null) {
                                LOG.severe("Error loading texture for " + entityName + " from file " + textureURL);
                            } else texture = ImageIO.read(textureFile);
                        }

                        e.setTexture(texture);

                        loc.addEntity(e);

                        LOG.finest("Added Entity " + e.toString());
                    }
                }

            }
            LOG.finest("Entitites done...");

            //* enemies parsing

            LOG.finest("Parsing enemies...");

            nl = doc.getElementsByTagName("enemies");

            if (nl.item(0) != null) {
                nl = nl.item(0).getChildNodes();

                for (int temp = 0; temp < nl.getLength(); temp++) {

                    Node nNode = nl.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode;

                        String archetype = eElement.getElementsByTagName("archetype").item(0).getTextContent();

                        int posX = Integer.parseInt(eElement.getElementsByTagName("pos-x").item(0).getTextContent());
                        int posY = Integer.parseInt(eElement.getElementsByTagName("pos-y").item(0).getTextContent());
                        int sizX = Integer.parseInt(eElement.getElementsByTagName("siz-x").item(0).getTextContent());
                        int sizY = Integer.parseInt(eElement.getElementsByTagName("siz-y").item(0).getTextContent());

                        EnemyArchetype enemyArchetype = null;
                        for (EnemyArchetype ea : gameRegistry.getEnemyArchetypes()) {
                            if (ea.getId().equals(archetype)) enemyArchetype = ea;
                        }

                        Enemy enemy = new Enemy(enemyArchetype, posX, posY, sizX, sizY);
                        enemy.setCollides(true);

                        loc.addEnemy(enemy);
                    }
                }

            }
            LOG.finest("Enemies done...");


            //* items parsing

            LOG.finest("Parsing Items...");

            nl = doc.getElementsByTagName("items");

            if (nl.item(0) != null) {
                nl = nl.item(0).getChildNodes();

                for (int temp = 0; temp < nl.getLength(); temp++) {

                    Node nNode = nl.item(temp);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode;

                        String archetype = eElement.getElementsByTagName("archetype").item(0).getTextContent();

                        int posX = Integer.parseInt(eElement.getElementsByTagName("pos-x").item(0).getTextContent());
                        int posY = Integer.parseInt(eElement.getElementsByTagName("pos-y").item(0).getTextContent());
                        int sizX = Integer.parseInt(eElement.getElementsByTagName("siz-x").item(0).getTextContent());
                        int sizY = Integer.parseInt(eElement.getElementsByTagName("siz-y").item(0).getTextContent());

                        ItemArchetype itemArchetype = null;
                        for (ItemArchetype ia : gameRegistry.getItemsArchetypes()) {
                            if (ia.getId().equals(archetype)) itemArchetype = ia;
                        }

                        Item item = new Item(itemArchetype, posX, posY, sizX, sizY);

                        loc.addItem(item);
                    }
                }
            }

            LOG.finest("Items done...");

            gameRegistry.getWorld().setLocationAt(mapX, mapY, loc);

        } catch (Exception e) {
            LOG.severe("Parsing of " + file.getName() + " failed.");
            e.printStackTrace();
        }
    }

}
