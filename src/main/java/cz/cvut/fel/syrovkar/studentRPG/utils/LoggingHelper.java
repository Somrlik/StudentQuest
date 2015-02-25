package cz.cvut.fel.syrovkar.studentRPG.utils;

import java.util.logging.Logger;

/**
 * Helps with logging.
 *
 * Created by Karel on 25. 2. 2015.
 */
public class LoggingHelper {

    public static Logger LOGGER = Logger.getLogger("GeneralLogger");

    public static void info(String info) {
        LOGGER.info(info);
    }

    public static void warning(String warning) {
        LOGGER.warning(warning);
    }

    public static void severe(String severe) {
        LOGGER.severe(severe);
    }

}
