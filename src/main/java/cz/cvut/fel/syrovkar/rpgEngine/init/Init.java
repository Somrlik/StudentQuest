package cz.cvut.fel.syrovkar.rpgEngine.init;

import cz.cvut.fel.syrovkar.rpgEngine.Game;
import cz.cvut.fel.syrovkar.rpgEngine.Player;

/**
 * Initializes all actor classes into GameRegistry.
 *
 * Created by Karel on 24. 2. 2015.
 */
public class Init {
    /* init of all attributes */
    /* init of player */
    /* init of all monsters */
    /* init of all locations */
    /* init of everything else */


    /* For the time being, everything is stored in here */

    public static void init() {

        Player player = Game.gameRegistry.getPlayer();

        player.addAttribute("Sex", "Male");

        player.setX(120);
        player.setY(120);

    }

}
