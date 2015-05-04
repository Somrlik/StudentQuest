package cz.cvut.fel.syrovkar.rpgEngine.utils;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Some useful helper for loading files.
 *
 * Created by Karel on 28. 4. 2015.
 */
public class FileHelper {

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
            System.out.println("Error loading file " + URI);
            return null;
        } else {
            File dir = null;
            try {
                dir = new File(url.toURI());
            } catch (URISyntaxException e) {
                System.out.println("Error opening url: " + url);
                e.printStackTrace();
            }
            return dir;
        }
    }

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
            System.out.println("Error loading files from directory: " + directory);
            return null;
        } else {
            File dir = null;
            try {
                dir = new File(url.toURI());
            } catch (URISyntaxException e) {
                System.out.println("Error opening url: " + url);
                e.printStackTrace();
            }
            ArrayList<File> files = new ArrayList<File>();
            try {
                if (dir.listFiles() == null) return null;
                Collections.addAll(files, dir.listFiles());
                return files;
            } catch (NullPointerException e) {
                System.out.println("Error loading resources from directory " + directory);
                return null;
            }
        }
    }

}
