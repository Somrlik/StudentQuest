package cz.cvut.fel.syrovkar.rpgEngine.renderer;

import cz.cvut.fel.syrovkar.rpgEngine.Game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Karel on 17. 3. 2015.
 */
public class Window {

    JFrame root;

    public Window() {
        root = new JFrame("RPG engine");
        root.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        root.setLayout(new FlowLayout());
        root.add(new JLabel("Trying out!"));
        root.add(new JButton("Press me!"));
        root.pack();
        root.setVisible(true);
        root.setSize(800, 600);
    }

    public void update() {
        if (Game.isModsLoaded()) {
            root.add(new JLabel("Mods loaded."));
            //root.pack();
        }
    }

}
