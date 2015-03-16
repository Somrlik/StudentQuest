package cz.cvut.fel.syrovkar.rpgEngine;

import cz.cvut.fel.syrovkar.rpgEngine.discovery.ModLoader;
import cz.cvut.fel.syrovkar.rpgEngine.utils.LoggingHelper;

/**
 * Holds main information and technical initialization of engine.
 * <p/>
 * Created by Karel on 19. 2. 2015.
 */
public class Main {

    public static void main(String[] args) {

        LoggingHelper.LOGGER.info("Running the stuff.");

        // Necessary, don't move / delete
        Game game = new Game();

        // Finds all mods subscribed with @Mod
        ModLoader.findMods();

        // Inits all mods and the whole game.
        game.init();

        System.out.println(Game.gameRegistry.toString());


    }
}
