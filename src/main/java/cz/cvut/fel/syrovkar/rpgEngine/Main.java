package cz.cvut.fel.syrovkar.rpgEngine;

import cz.cvut.fel.syrovkar.rpgEngine.gui.MainWindow;

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

    public static void main(String[] args) {

        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);

        Logger.getLogger("cz.cvut.fel.syrovkar").setUseParentHandlers(false);
        Logger.getLogger("cz.cvut.fel.syrovkar").setLevel(Level.FINER);
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

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //System.out.println(Game.gameRegistry.getWorld().getLocationAt(5, 5).toString());

        LOG.info("Main thread's work done...");
    }

}
