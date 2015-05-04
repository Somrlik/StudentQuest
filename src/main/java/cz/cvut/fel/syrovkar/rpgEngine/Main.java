package cz.cvut.fel.syrovkar.rpgEngine;

import cz.cvut.fel.syrovkar.rpgEngine.gui.MainWindow;
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

        System.out.println(Game.gameRegistry.getWorld().getLocationAt(5, 5).toString());
    }

}
