package cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Attribute;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.ItemArchetype;
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
 * Parses .xml files with ItemArchetype
 * <p/>
 * Created by Karel on 28. 4. 2015.
 */
public class ItemsParser {

    private static final Logger LOG = Logger.getLogger(ItemsParser.class.getName());

    /**
     * Parses .xml with ItemArchetype.
     * <p/>
     * For more info on how to make such a xml file, see "examples/".
     *
     * @param file .xml file with ItemArchetype
     */

    public static void parse(File file, GameRegistry gameRegistry) {
        try {

            LOG.finer("Parsing ItemArchetype file " + file.getName());

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            String name = "", id = "", textureURL = "";
            HashSet<Attribute> attributes = null;

            NodeList nl = doc.getElementsByTagName("name");
            if (nl.item(0) != null) name = nl.item(0).getTextContent();

            nl = doc.getElementsByTagName("id");
            if (nl.item(0) != null) id = nl.item(0).getTextContent();

            nl = doc.getElementsByTagName("texture");
            if (nl.item(0) != null) textureURL = nl.item(0).getTextContent();

            nl = doc.getElementsByTagName("attributes");
            if (nl.item(0) != null) attributes = AttributesParser.parse(nl);

            if (name.isEmpty() || id.isEmpty()) {
                LOG.severe("No name or ID. Skipping...");
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

            gameRegistry.addItemArchetype(new ItemArchetype(name, id, texture, attributes));

        } catch (Exception e) {
            LOG.severe("Parsing of " + file.getName() + " failed.");
            e.printStackTrace();
        }
    }

}
