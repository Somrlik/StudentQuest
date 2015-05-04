package cz.cvut.fel.syrovkar.rpgEngine.init;

import cz.cvut.fel.syrovkar.rpgEngine.utils.FileHelper;
import cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers.LocationsParser;

import java.io.File;
import java.util.logging.Logger;

/**
 * Parser wrapper
 *
 * Created by Karel on 24. 2. 2015.
 */
public class LocationsInit {

    private static final Logger LOG = Logger.getLogger(LocationsInit.class.getName());

    /**
     * Parses all files in "locations/"
     */
    public static void init() {
        for (File f : FileHelper.getFilesFromDirectory("locations/")) {
            LocationsParser.parse(f);
        }
    }
}
