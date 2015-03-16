package cz.cvut.fel.syrovkar.rpgEngine.init;

import cz.cvut.fel.syrovkar.rpgEngine.Player;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Character;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Item;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Location;
import cz.cvut.fel.syrovkar.rpgEngine.discovery.ModHolderObject;
import cz.cvut.fel.syrovkar.rpgEngine.discovery.ModLoaderException;
import cz.cvut.fel.syrovkar.rpgEngine.utils.LoggingHelper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class hold all classes of all actors, mainly for reference and instantination purposes.
 *
 * Created by Karel on 24. 2. 2015.
 */
public class GameRegistry {

    private List<ModHolderObject> mods;

    private List<Character> characters;

    private List<Location> locations;

    private List<Item> items;

    private Player player;

    public GameRegistry() {

        mods = new ArrayList<ModHolderObject>();

        characters = new ArrayList<Character>();

        locations = new ArrayList<Location>();

        items = new ArrayList<Item>();

        player = new Player();

    }

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addMod(ModHolderObject mho) throws ModLoaderException {
        if (mods.contains(mho)) throw new ModLoaderException("Mod is already contained, skipping.");
        mods.add(mho);
    }

    @Override
    public String toString() {
        return "GameRegistry{" +
                "mods=" + mods +
                ", characters=" + characters +
                ", locations=" + locations +
                ", items=" + items +
                ", player=" + player +
                '}';
    }

    public void invokeInitOnMods() {
        LoggingHelper.LOGGER.info("Trying to init mods.");
        for (ModHolderObject mod : mods) {
            try {
                if (mod.getInit() != null) mod.getInit().invoke(mod.getInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public Player getPlayer() {
        return player;
    }
}
