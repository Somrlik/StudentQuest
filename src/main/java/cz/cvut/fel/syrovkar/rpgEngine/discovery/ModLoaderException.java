package cz.cvut.fel.syrovkar.rpgEngine.discovery;

import cz.cvut.fel.syrovkar.rpgEngine.utils.LoggingHelper;

/**
 * Called when something goes wrong in modLoader.
 * <p/>
 * Created by Karel on 16. 3. 2015.
 */
public class ModLoaderException extends Exception {

    public ModLoaderException(String message) {
        LoggingHelper.LOGGER.severe("Failed loading mod with message: " + message);
    }

}
