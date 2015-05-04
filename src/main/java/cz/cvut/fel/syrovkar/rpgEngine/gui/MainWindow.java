package cz.cvut.fel.syrovkar.rpgEngine.gui;

import cz.cvut.fel.syrovkar.rpgEngine.reference.Constants;

import javax.swing.*;
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

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        LOG.info("Set size of window to " + Constants.WINDOW_WIDTH + "x" + Constants.WINDOW_HEIGHT);

        LOG.info("Created GUI on EDT? " +
                SwingUtilities.isEventDispatchThread());

    }

}