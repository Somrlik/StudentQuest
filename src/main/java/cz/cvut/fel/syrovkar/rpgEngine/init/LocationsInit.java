package cz.cvut.fel.syrovkar.rpgEngine.init;

import cz.cvut.fel.syrovkar.rpgEngine.utils.FileHelper;
import cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers.LocationsParser;

import java.io.File;

/**
 * Parser wrapper
 *
 * Created by Karel on 24. 2. 2015.
 */
public class LocationsInit {
    /**
     * Parses all files in "locations/"
     */
    public static void init() {
        for (File f : FileHelper.getFilesFromDirectory("locations/")) {
            LocationsParser.parse(f);
        }
    }
}
