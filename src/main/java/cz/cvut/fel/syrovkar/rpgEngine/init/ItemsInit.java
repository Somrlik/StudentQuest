package cz.cvut.fel.syrovkar.rpgEngine.init;

import cz.cvut.fel.syrovkar.rpgEngine.utils.FileHelper;
import cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers.ItemsParser;

import java.io.File;

/**
 * Items parser wrapper
 *
 * Created by Karel on 28. 4. 2015.
 */
public class ItemsInit {
    /**
     * Parses all files in "items/"
     */
    public static void init() {
        for (File f : FileHelper.getFilesFromDirectory("items/")) {
            ItemsParser.parse(f);
        }
    }
}
