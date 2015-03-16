package cz.cvut.fel.syrovkar.rpgEngine.renderer;

import javax.swing.*;
import java.awt.*;


/**
 * Basic GUI class.
 * <p/>
 * Created by Karel on 16. 3. 2015.
 */
public class Renderer implements Runnable {

    private static int fps = 1000 / 60;

    @Override
    public synchronized void run() {
        JFrame window = new JFrame("Window title");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLayout(new FlowLayout());
        window.add(new JLabel("Trying out!"));
        window.add(new JButton("Press me!"));
        window.pack();
        window.setVisible(true);
    }

    public synchronized void update() {
    }


}
