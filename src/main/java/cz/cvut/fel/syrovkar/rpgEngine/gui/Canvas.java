package cz.cvut.fel.syrovkar.rpgEngine.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Drawing Canvas.
 *
 * Created by Karel on 24. 3. 2015.
 */

public class Canvas extends java.awt.Canvas {
    BufferStrategy strategy = null;

    public Canvas(JFrame frame) {
        JPanel panel = (JPanel) frame.getContentPane();

        panel.setPreferredSize(new Dimension(800, 600));
        panel.setFocusable(true);
        //panel.add(this);

        //setBounds(0, 0, 800, 600);

        setIgnoreRepaint(true);

        requestFocus();

        // listeners
        PlayerInteraction interaction = new PlayerInteraction();

        addMouseListener(interaction);
        addMouseMotionListener(interaction);
        addMouseWheelListener(interaction);
        addKeyListener(interaction);

        System.out.println("Created GUI on EDT? " +
                SwingUtilities.isEventDispatchThread());


    }

    public void startDoubleBuffer() {
        // create the buffering strategy which will allow AWT
        // to manage our accelerated graphics
        createBufferStrategy(2);
        strategy = getBufferStrategy();
    }

    public void update() {
        strategy.show();
    }

    public Graphics2D getDrawingGraphics() {
        if (strategy == null) {
            return null;
        }
        return (Graphics2D) strategy.getDrawGraphics();
    }
}


