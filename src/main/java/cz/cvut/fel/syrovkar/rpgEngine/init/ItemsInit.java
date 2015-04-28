package cz.cvut.fel.syrovkar.rpgEngine.init;

import cz.cvut.fel.syrovkar.rpgEngine.utils.FileHelper;
import cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers.ItemsParser;

import java.io.File;

/**
 * Created by Karel on 28. 4. 2015.
 */
public class ItemsInit {
    public static void init() {
        for (File f : FileHelper.getFilesFromDirectory("items/")) {
            ItemsParser.parse(f);
        }
    }

    private static void parse(File file) {
        System.out.println(file.toString());
    }
}
