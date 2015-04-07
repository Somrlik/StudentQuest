package cz.cvut.fel.syrovkar.rpgEngine.gui;

import java.awt.event.*;

/**
 * Created by Karel on 7. 4. 2015.
 */
public class PlayerInteraction implements MouseListener, KeyListener, MouseMotionListener, MouseWheelListener {

    public static boolean isUpPressed = false;
    public static boolean isDownPressed = false;
    public static boolean isLeftPressed = false;
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
                break;
            case KeyEvent.VK_DOWN:
                isDownPressed = true;
                break;
            case KeyEvent.VK_LEFT:
                isLeftPressed = true;
                break;
            case KeyEvent.VK_RIGHT:
                isRightPressed = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                isUpPressed = false;
                break;
            case KeyEvent.VK_DOWN:
                isDownPressed = false;
                break;
            case KeyEvent.VK_LEFT:
                isLeftPressed = false;
                break;
            case KeyEvent.VK_RIGHT:
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
