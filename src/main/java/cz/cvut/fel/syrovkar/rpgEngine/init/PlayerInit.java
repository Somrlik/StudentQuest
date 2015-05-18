package cz.cvut.fel.syrovkar.rpgEngine.init;

import cz.cvut.fel.syrovkar.rpgEngine.utils.FileHelper;
import cz.cvut.fel.syrovkar.rpgEngine.utils.xmlHelpers.PlayerParser;

import java.util.logging.Logger;

/**
 * Initializes the Player.
 *
 * Created by Karel on 24. 2. 2015.
 */
public class PlayerInit {

    private static final Logger LOG = Logger.getLogger(PlayerInit.class.getName());

    /**
     * Parses "player.xml"
     */
    public static void init(GameRegistry gameRegistry) {

        //Player player = gameRegistry.getPlayer();

        PlayerParser.parse(FileHelper.getFileFromURI("player.xml"), gameRegistry);

    }
}
