package cz.cvut.fel.syrovkar.rpgEngine.init;

import cz.cvut.fel.syrovkar.rpgEngine.utils.FileHelper;
import cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers.ItemsParserer;

import java.io.File;
import java.util.logging.Logger;

/**
 * Items parser wrapper
 *
 * Created by Karel on 28. 4. 2015.
 */
public class ItemsInit {

    private static final Logger LOG = Logger.getLogger(ItemsInit.class.getName());

    /**
     * Parses all files in "items/"
     */
    public static void init(GameRegistry gameRegistry) {
        for (File f : FileHelper.getFilesFromDirectory("items/")) {
            ItemsParserer.parse(f, gameRegistry);
        }
    }
}
