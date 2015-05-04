package cz.cvut.fel.syrovkar.rpgEngine.init;

import cz.cvut.fel.syrovkar.rpgEngine.Game;
import cz.cvut.fel.syrovkar.rpgEngine.utils.FileHelper;
import cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers.PlayerParser;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Player;

/**
 * Initializes the Player.
 *
 * Created by Karel on 24. 2. 2015.
 */
public class PlayerInit {

    /**
     * Parses "player.xml"
     */
    public static void init() {

        Player player = Game.gameRegistry.getPlayer();

        PlayerParser.parse(FileHelper.getFileFromURI("player.xml"));

    }
}
