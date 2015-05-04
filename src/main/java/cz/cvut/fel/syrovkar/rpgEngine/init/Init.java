package cz.cvut.fel.syrovkar.rpgEngine.init;

import cz.cvut.fel.syrovkar.rpgEngine.utils.FileHelper;
import cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers.WorldParser;

/**
 * Initializes all Archetypes and Locations into GameRegistry.
 *
 * Created by Karel on 24. 2. 2015.
 */
public class Init {
    /* init of all attributes */
    /* init of player */
    /* init of all monsters */
    /* init of all locationsInit */
    /* init of everything else */


    /* For the time being, everything is stored in here */

    /**
     * Init all the things.
     */
    public static void init() {

        WorldParser.parse(FileHelper.getFileFromURI("world.xml"));

        ItemsInit.init();
        EnemiesInit.init();
        LocationsInit.init();
        PlayerInit.init();
    }

}
