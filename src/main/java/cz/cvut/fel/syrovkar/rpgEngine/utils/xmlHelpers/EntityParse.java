package cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers;

import org.w3c.dom.Document;

/**
 * Parses name, id, pos-x, pos-y, siz-x, siz-y
 * <p/>
 * Created by Karel on 28. 4. 2015.
 */
public class EntityParse {

    public static void parse(Document doc, String name, String id,
                             Integer posX, Integer posY,
                             Integer sizX, Integer sizY) {

        System.out.println("Blah");

        doc.getElementsByTagName("name").item(0).getTextContent();
        doc.getElementsByTagName("id").item(0).getTextContent();
        doc.getElementsByTagName("pos-x").item(0).getNodeValue();
        doc.getElementsByTagName("pos-y").item(0).getNodeValue();
        doc.getElementsByTagName("siz-x").item(0).getNodeValue();
        doc.getElementsByTagName("siz-y").item(0).getNodeValue();

        System.out.println(doc.getElementsByTagName("sizY").item(0).getNodeValue());

    }

}
