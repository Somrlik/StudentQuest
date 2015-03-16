package cz.cvut.fel.syrovkar.rpgEngine.discovery;

import cz.cvut.fel.syrovkar.rpgEngine.Mod;

import java.lang.reflect.Method;

/**
 * Holds mods, some of their methods and calls.
 * <p/>
 * Created by Karel on 16. 3. 2015.
 */
public class ModHolderObject {

    private Class<?> me;

    private String name;

    private String modId;

    private Method init;

    private Object instance;

    /**
     * Makes a new mod holder.
     *
     * @param me class of object
     */
    public ModHolderObject(Class<?> me) throws ModLoaderException {
        this.me = me;
        try {
            this.instance = me.newInstance();
        } catch (InstantiationException e) {
            throw new ModLoaderException(e.getMessage());
        } catch (IllegalAccessException e) {
            throw new ModLoaderException(e.getMessage());
        }

        modId = me.getAnnotation(Mod.class).modId();
        name = me.getAnnotation(Mod.class).modName();

    }

    /**
     * Gets the name of mod.
     *
     * @return name fo mod
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the method of initialization.
     *
     * @return init method
     */
    public Method getInit() {
        return init;
    }

    /**
     * Sets the method of initialization.
     *
     * @param init method
     */
    public void setInit(Method init) {
        this.init = init;
    }

    /**
     * Gets modid of mod.
     *
     * @return modid
     */
    public String getModId() {
        return modId;
    }

    /**
     * Gets class of the mod.
     *
     * @return class of the mod
     */
    public Class<?> getMe() {
        return me;
    }

    /**
     * Gets instance of this mod, mainly for invoking stuff.
     *
     * @return instance of this mod.
     */
    public Object getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "ModHolderObject{" +
                "name='" + name + '\'' +
                ", modId='" + modId + '\'' +
                '}';
    }
}
