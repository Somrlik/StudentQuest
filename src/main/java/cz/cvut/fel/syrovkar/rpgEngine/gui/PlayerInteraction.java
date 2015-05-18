package cz.cvut.fel.syrovkar.rpgEngine.gui;

import cz.cvut.fel.syrovkar.rpgEngine.reference.Constants;

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

    /**
     * True if ATTACK key is pressed
     */
    public static boolean isAttackPressed = false;

    /**
     * True if INVENTORY key is pressed
     */
    public static boolean isInventoryPressed = false;

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
            case Constants.UP_MOVEMENT_KEY:
                isUpPressed = true;
                LOG.finest("Pressed UP");
                break;
            case Constants.DOWN_MOVEMENT_KEY:
                isDownPressed = true;
                LOG.finest("Pressed DOWN");
                break;
            case Constants.LEFT_MOVEMENT_KEY:
                isLeftPressed = true;
                LOG.finest("Pressed LEFT");
                break;
            case Constants.RIGHT_MOVEMENT_KEY:
                isRightPressed = true;
                LOG.finest("Pressed RIGHT");
                break;
            case Constants.INVENTORY_KEY:
                isInventoryPressed = true;
                LOG.finest("Inventory key pressed");
                break;
            case Constants.ATTACK_KEY:
                isAttackPressed = true;
                LOG.finest("Attack key pressed");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case Constants.UP_MOVEMENT_KEY:
                isUpPressed = false;
                LOG.finest("Released UP");
                break;
            case Constants.DOWN_MOVEMENT_KEY:
                LOG.finest("Released DOWN");
                isDownPressed = false;
                break;
            case Constants.LEFT_MOVEMENT_KEY:
                LOG.finest("Released LEFT");
                isLeftPressed = false;
                break;
            case Constants.RIGHT_MOVEMENT_KEY:
                LOG.finest("Released RIGHT");
                isRightPressed = false;
                break;
            case Constants.INVENTORY_KEY:
                isInventoryPressed = false;
                LOG.finest("Inventory key released");
                break;
            case Constants.ATTACK_KEY:
                isAttackPressed = false;
                LOG.finest("Attack key released");
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
