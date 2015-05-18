package cz.cvut.fel.syrovkar.rpgEngine.gui;

import java.awt.event.*;
import java.util.logging.Logger;

/**
 * Class for managing inputs on all devices.
 *
 * Listens for input on Swing/AWT event thread.
 *
 * Created by Karel on 7. 4. 2015.
 */
public class PlayerInteraction implements MouseListener, KeyListener, MouseMotionListener, MouseWheelListener {

    private static final Logger LOG = Logger.getLogger(PlayerInteraction.class.getName());

    /**
     * True if the UP key is pressed
     */
    public static boolean isUpPressed = false;
    /**
     * True if the DOWN key is pressed
     */
    public static boolean isDownPressed = false;
    /**
     * True if the LEFT key is pressed
     */
    public static boolean isLeftPressed = false;
    /**
     * True if the RIGHT key is pressed
     */
    public static boolean isRightPressed = false;

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        //System.out.println(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                isUpPressed = true;
                LOG.finest("Pressed UP");
                break;
            case KeyEvent.VK_DOWN:
                isDownPressed = true;
                LOG.finest("Pressed DOWN");
                break;
            case KeyEvent.VK_LEFT:
                isLeftPressed = true;
                LOG.finest("Pressed LEFT");
                break;
            case KeyEvent.VK_RIGHT:
                isRightPressed = true;
                LOG.finest("Pressed RIGHT");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                isUpPressed = false;
                LOG.finest("Released UP");
                break;
            case KeyEvent.VK_DOWN:
                LOG.finest("Released DOWN");
                isDownPressed = false;
                break;
            case KeyEvent.VK_LEFT:
                LOG.finest("Released LEFT");
                isLeftPressed = false;
                break;
            case KeyEvent.VK_RIGHT:
                LOG.finest("Released RIGHT");
                isRightPressed = false;
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.println(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //System.out.println(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println(e);
    }
}
