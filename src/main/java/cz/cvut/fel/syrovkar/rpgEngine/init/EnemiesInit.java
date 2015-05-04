package cz.cvut.fel.syrovkar.rpgEngine.init;

import cz.cvut.fel.syrovkar.rpgEngine.utils.FileHelper;
import cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers.EnemyParser;

import java.io.File;

/**
 * Parser wrapper.
 *
 * Created by Karel on 28. 4. 2015.
 */
public class EnemiesInit {

    /**
     * Parses all resources in "enemies/"
     */
    public static void init() {
        for (File f : FileHelper.getFilesFromDirectory("enemies/")) {
            EnemyParser.parse(f);
        }
    }

}
