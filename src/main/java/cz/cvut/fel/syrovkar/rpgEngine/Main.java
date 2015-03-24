package cz.cvut.fel.syrovkar.rpgEngine;

import cz.cvut.fel.syrovkar.rpgEngine.renderer.Renderer;
import cz.cvut.fel.syrovkar.rpgEngine.utils.LoggingHelper;

import javax.swing.*;

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

        // Thread for the game
        Thread gameThread = new Thread(game);
        gameThread.start();

        // Thread for the renderer
        Renderer renderer = new Renderer();
        SwingUtilities.invokeLater(renderer);

        // And the main thread for loading stuff in the meantime.

        // Inits all mods and the whole game.
        game.init();

        System.out.println(Game.gameRegistry.toString());

    }
}
