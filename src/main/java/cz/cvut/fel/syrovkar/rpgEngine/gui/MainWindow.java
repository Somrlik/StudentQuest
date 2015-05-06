package cz.cvut.fel.syrovkar.rpgEngine.gui;

import cz.cvut.fel.syrovkar.rpgEngine.Game;
import cz.cvut.fel.syrovkar.rpgEngine.reference.Constants;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Logger;

/**
 * Inits the main window.
 *
 * Created by Karel on 24. 3. 2015.
 */
public class MainWindow {

    private static final Logger LOG = Logger.getLogger(MainWindow.class.getName());

    static JFrame frame = new JFrame("Game");

    public static volatile Canvas canvas = new Canvas(frame);

    public MainWindow() {
        frame.add(canvas);
        frame.pack();

        canvas.startDoubleBuffer();
        canvas.setFocusable(true);

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                LOG.info("Window opened...");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                LOG.info("Window closing, waiting for Game to exit...");
                while (Game.isRunning) {
                    Game.exit();
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {
                LOG.info("Main window closed.");
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        LOG.info("Set size of window to " + Constants.WINDOW_WIDTH + "x" + Constants.WINDOW_HEIGHT);

        LOG.info("Created GUI on EDT? " +
                SwingUtilities.isEventDispatchThread());

    }

}