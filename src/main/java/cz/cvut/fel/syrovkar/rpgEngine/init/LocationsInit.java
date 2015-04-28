package cz.cvut.fel.syrovkar.rpgEngine.init;

import cz.cvut.fel.syrovkar.rpgEngine.utils.FileHelper;
import cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers.LocationsParser;

import java.io.File;

/**
 * Initializes all location classes.
 * Created by Karel on 24. 2. 2015.
 */
public class LocationsInit {
    public static void init() {
        for (File f : FileHelper.getFilesFromDirectory("locations/")) {
            LocationsParser.parse(f);
        }
    }
}
