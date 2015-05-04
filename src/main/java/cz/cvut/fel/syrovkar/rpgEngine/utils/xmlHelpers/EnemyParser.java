package cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers;

import cz.cvut.fel.syrovkar.rpgEngine.Game;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Attribute;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.EnemyArchetype;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.EnemyDrop;
import cz.cvut.fel.syrovkar.rpgEngine.utils.FileHelper;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Logger;

/**
 * Parses .xml files that contain Archetypes of Enemies.
 *
 * Created by Karel on 28. 4. 2015.
 */
public class EnemyParser {

    private static final Logger LOG = Logger.getLogger(EnemyParser.class.getName());

    /**
     * Parses .xml with EnemyArchetype.
     * <p/>
     * For more info on how to make such a xml file, see "examples/".
     *
     * @param file .xml file with EnemyArchetype
     */
    public static void parse(File file) {
        try {

            LOG.finer("Parsing EnemyArchetype file " + file.getName());

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            String name = "", id = "", textureURL = "";
            HashSet<Attribute> attributes = null;
            ArrayList<EnemyDrop> drops = null;

            NodeList nl = doc.getElementsByTagName("name");
            if (nl != null) name = nl.item(0).getTextContent();

            nl = doc.getElementsByTagName("id");
            if (nl != null) id = nl.item(0).getTextContent();

            nl = doc.getElementsByTagName("texture");
            if (nl != null) textureURL = nl.item(0).getTextContent();

            nl = doc.getElementsByTagName("attributes");
            if (nl != null) attributes = AttributesParser.parse(nl);

            nl = doc.getElementsByTagName("drops");
            if (nl != null) drops = DropsParser.parse(nl);

            if (name.isEmpty() || id.isEmpty()) {
                LOG.severe("No ID or name, skipping...");
                return;
            }

            // Texture loading
            Image texture = null;
            if (!textureURL.isEmpty()) {
                File textureFile = FileHelper.getFileFromURI("textures/" + textureURL);
                if (textureFile == null) {
                    LOG.severe("Error loading texture for " + name + " from file " + textureURL);
                } else {
                    LOG.finest("Loaded texture for " + name + " from file " + textureURL);
                    texture = ImageIO.read(textureFile);
                }
            }

            Game.gameRegistry.addEnemyArchetype(new EnemyArchetype(name, id, texture, attributes, drops));

        } catch (Exception e) {
            LOG.severe("Parsing of " + file.getName() + " failed.");
            e.printStackTrace();
        }
    }

}
