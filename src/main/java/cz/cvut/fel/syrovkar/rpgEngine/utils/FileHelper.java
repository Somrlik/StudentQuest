package cz.cvut.fel.syrovkar.rpgEngine.utils;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * Some useful helper for loading files.
 *
 * Created by Karel on 28. 4. 2015.
 */
public class FileHelper {

    private static final Logger LOG = Logger.getLogger(FileHelper.class.getName());

    /**
     * Gets File from URI.
     *
     * @param URI URI of the file.
     * @return File resource, null on failure
     */
    public static File getFileFromURI(String URI) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        URL url = classLoader.getResource(URI);

        if (url == null) {
            LOG.warning("Error loading file " + URI);
            return null;
        } else {
            File dir = null;
            try {
                dir = new File(url.toURI());
            } catch (URISyntaxException e) {
                LOG.warning("Error opening url: " + url);
                e.printStackTrace();
            }
            return dir;
        }
    }

    /*
    public static File getFileFromURI(String URI) {
        System.out.println("/"+URI);
        InputStream in = FileHelper.class.getResourceAsStream("/"+URI);
        System.out.println(in);
        File file = new File("");

        return null;
    }
    */

    /**
     * Gets list of all files from directory
     *
     * @param directory URI of directory
     * @return List of Files, null on failure
     */
    public static List<File> getFilesFromDirectory(String directory) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        URL url = classLoader.getResource(directory);

        if (url == null) {
            LOG.warning("Error loading files from directory: " + directory);
            return null;
        } else {
            File dir = null;
            try {
                dir = new File(url.toURI());
            } catch (URISyntaxException e) {
                LOG.warning("Error opening url: " + url);
                e.printStackTrace();
            }
            ArrayList<File> files = new ArrayList<File>();
            try {
                if ((dir != null ? dir.listFiles() : new File[0]) == null) return null;
                Collections.addAll(files, dir.listFiles());
                return files;
            } catch (NullPointerException e) {
                LOG.warning("Error loading resources from directory " + directory);
                return null;
            }
        }
    }

}
