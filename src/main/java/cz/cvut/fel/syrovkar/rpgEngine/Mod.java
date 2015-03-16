package cz.cvut.fel.syrovkar.rpgEngine;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Class for adding mods to the engine.
 * <p/>
 * TODO Usage
 * <p/>
 * Created by Karel on 11. 3. 2015.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Mod {

    /**
     * Provide an unique modId for your mod.
     *
     * @return Mod id
     */
    String modId();

    /**
     * Provide a human-readable name.
     *
     * @return Nice name
     */
    String modName() default "";

    /**
     * Stuff everything you want loaded here.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface Init {

    }

}
