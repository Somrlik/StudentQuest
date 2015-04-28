package cz.cvut.fel.syrovkar.rpgEngine.init;

import cz.cvut.fel.syrovkar.rpgEngine.Game;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Player;

/**
 * Initializes the Player.
 *
 * Created by Karel on 24. 2. 2015.
 */
public class PlayerInit {

    public static void init() {

        Player player = Game.gameRegistry.getPlayer();

        player.addAttribute("Sex", "Male");

        player.setX(120);
        player.setY(120);
    }
}
