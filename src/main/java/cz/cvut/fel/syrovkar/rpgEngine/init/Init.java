package cz.cvut.fel.syrovkar.rpgEngine.init;

/**
 * Initializes all actor classes into GameRegistry.
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

    public static void init() {
        ItemsInit.init();
        EnemiesInit.init();
        LocationsInit.init();
        PlayerInit.init();
    }

}
