package cz.cvut.fel.syrovkar.rpgEngine.init;

import cz.cvut.fel.syrovkar.rpgEngine.utils.FileHelper;
import cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers.EnemyParser;

import java.io.File;
import java.util.logging.Logger;

/**
 * Parser wrapper.
 *
 * Created by Karel on 28. 4. 2015.
 */
public class EnemiesInit {

    private static final Logger LOG = Logger.getLogger(EnemiesInit.class.getName());

    /**
     * Parses all resources in "enemies/"
     */
    public static void init(GameRegistry gameRegistry) {
        for (File f : FileHelper.getFilesFromDirectory("enemies/")) {
            EnemyParser.parse(f, gameRegistry);
        }
    }

}
