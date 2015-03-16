package cz.cvut.fel.syrovkar.rpgEngine.discovery;

import cz.cvut.fel.syrovkar.rpgEngine.Game;
import cz.cvut.fel.syrovkar.rpgEngine.Mod;
import cz.cvut.fel.syrovkar.rpgEngine.utils.LoggingHelper;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * Class for loading mods.
 * <p/>
 * Created by Karel on 16. 3. 2015.
 */

public class ModLoader {

    /**
     * Scans all packages present in classpath and searches for @Mod annotation.
     * Then makes a ModHolderObject
     */
    public static void findMods() {

        LoggingHelper.LOGGER.info("Searching for mods...");

        Reflections reflections = new Reflections();
        Set<Class<?>> modClasses = reflections.getTypesAnnotatedWith(Mod.class);

        for (Class<?> clazz : modClasses) {
            try {
                LoggingHelper.LOGGER.info("Loading mod " + clazz.toString());
                loadMod(clazz);
            } catch (ModLoaderException e) {
                LoggingHelper.LOGGER.severe("ModLoader failed to load " + clazz.toString());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                LoggingHelper.LOGGER.info("Mod " + clazz.toString() + " parsed.");
            }
        }

        LoggingHelper.LOGGER.info("Mods loaded.");
    }

    private static void loadMod(Class<?> clazz) throws ModLoaderException {

        ModHolderObject modHolder = new ModHolderObject(clazz);

        Method initMethod = null;

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Mod.Init.class)) {
                initMethod = method;
            }
        }

        // You can add more fields here.

        if (initMethod != null) {
            modHolder.setInit(initMethod);
        } else {
            modHolder.setInit(null);
        }

        Game.gameRegistry.addMod(modHolder);

    }

}
