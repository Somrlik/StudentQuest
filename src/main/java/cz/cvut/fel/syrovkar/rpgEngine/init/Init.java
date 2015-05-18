package cz.cvut.fel.syrovkar.rpgEngine.init;

import cz.cvut.fel.syrovkar.rpgEngine.utils.FileHelper;
import cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers.WorldParser;

import java.util.logging.Logger;

/**
 * Initializes all Archetypes and Locations into GameRegistry.
 *
 * Created by Karel on 24. 2. 2015.
 */
public class Init {

    private static final Logger LOG = Logger.getLogger(Init.class.getName());

    /* init of all attributes */
    /* init of player */
    /* init of all monsters */
    /* init of all locationsInit */
    /* init of everything else */


    /* For the time being, everything is stored in here */

    /**
     * Init all the things.
     */
    public static void init(GameRegistry gameRegistry) {

        LOG.info("Init started...");

        LOG.fine("World init started...");
        WorldParser.parse(FileHelper.getFileFromURI("world.xml"), gameRegistry);
        LOG.fine("World init ended...");

        LOG.fine("Items init started...");
        ItemsInit.init(gameRegistry);
        LOG.fine("Items init ended...");

        LOG.fine("Enemies init started...");
        EnemiesInit.init(gameRegistry);
        LOG.fine("Enemies init ended...");

        LOG.fine("Locations init started...");
        LocationsInit.init(gameRegistry);
        LOG.fine("Locations init ended...");

        LOG.fine("Player init started...");
        PlayerInit.init(gameRegistry);
        LOG.fine("Player init ended...");

        LOG.fine("Misc init started..");
        MiscInit.init(gameRegistry);
        LOG.fine("Misc init ended...");

        LOG.info("Init done...");

    }

}
