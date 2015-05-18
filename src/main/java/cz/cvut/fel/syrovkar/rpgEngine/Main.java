package cz.cvut.fel.syrovkar.rpgEngine;

import cz.cvut.fel.syrovkar.rpgEngine.gui.MainWindow;
import cz.cvut.fel.syrovkar.rpgEngine.init.GameRegistry;
import cz.cvut.fel.syrovkar.rpgEngine.init.Init;

import javax.swing.*;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Holds main information and technical initialization of engine.
 * <p/>
 * Created by Karel on 19. 2. 2015.
 */
public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    /**
     * Well...
     *
     * @param args Array of arguments
     */
    public static void main(String[] args) {

        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);

        Logger.getLogger("cz.cvut.fel.syrovkar").setUseParentHandlers(false);
        Logger.getLogger("cz.cvut.fel.syrovkar").setLevel(Level.FINEST);
        Logger.getLogger("cz.cvut.fel.syrovkar").addHandler(handler);


        LOG.info("Starting Main thread...");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });

        Game game = new Game();
        Thread gameThread = new Thread(game);
        gameThread.start();

        GameRegistry gameRegistry = new GameRegistry();

        LOG.info("GameRegistry created, starting Init...");

        Init.init(gameRegistry);

        LOG.info("Init done, giving GameRegistry to Game");

        GameRegistry.isLoaded = true;

        Game.gameRegistry = gameRegistry;

        LOG.info("Main thread's work done...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
