package cz.cvut.fel.syrovkar.rpgEngine.gui;

import cz.cvut.fel.syrovkar.rpgEngine.reference.Constants;

import javax.swing.*;

/**
 * Created by Karel on 24. 3. 2015.
 */
public class MainWindow {

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

        System.out.println("Created GUI on EDT? " +
                SwingUtilities.isEventDispatchThread());

    }

}