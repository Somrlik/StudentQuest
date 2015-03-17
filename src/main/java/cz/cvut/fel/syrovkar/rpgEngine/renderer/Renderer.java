package cz.cvut.fel.syrovkar.rpgEngine.renderer;

/**
 * Basic GUI class.
 * TODO Handle changes using events?
 * <p/>
 * Created by Karel on 16. 3. 2015.
 */
public class Renderer implements Runnable {

    private Window mainWindow;

    private static int fps = 1000 / 60;

    @Override
    public synchronized void run() {
        mainWindow = new Window();
    }

    public synchronized void update() {
        mainWindow.update();
    }

}
