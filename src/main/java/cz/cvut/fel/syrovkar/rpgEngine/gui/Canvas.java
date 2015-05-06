package cz.cvut.fel.syrovkar.rpgEngine.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.logging.Logger;

/**
 * Drawing Canvas, based on AWT's Canvas. Supports double buffering.
 *
 * Created by Karel on 24. 3. 2015.
 */

public class Canvas extends java.awt.Canvas {

    private static final Logger LOG = Logger.getLogger(Canvas.class.getName());

    BufferStrategy strategy = null;

    /**
     * @param frame Parent JFrame to display the Canvas
     */
    public Canvas(JFrame frame) {
        JPanel panel = (JPanel) frame.getContentPane();

        panel.setPreferredSize(new Dimension(800, 600));
        panel.setFocusable(true);

        setIgnoreRepaint(true);

        requestFocus();

        PlayerInteraction interaction = new PlayerInteraction();

        addMouseListener(interaction);
        addMouseMotionListener(interaction);
        addMouseWheelListener(interaction);
        addKeyListener(interaction);

        LOG.info("Created GUI on EDT? Should be false: " +
                SwingUtilities.isEventDispatchThread());
    }

    /**
     * Tries to create double buffering for the Canvas
     */
    public void startDoubleBuffer() {
        // create the buffering strategy which will allow AWT
        // to manage our accelerated graphics
        createBufferStrategy(2);
        strategy = getBufferStrategy();
    }

    /**
     * Called by Swing itself
     */
    public void update() {
        strategy.show();
    }

    /**
     * Used to get the Graphics to draw on.
     *
     * @return Graphics of the canvas
     */
    public Graphics2D getDrawingGraphics() {
        if (strategy == null) {
            return null;
        }
        return (Graphics2D) strategy.getDrawGraphics();
    }
}


