package cz.cvut.fel.syrovkar.rpgEngine.init;

import cz.cvut.fel.syrovkar.rpgEngine.Player;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Character;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Item;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * This class hold all classes of all actors, mainly for reference and instantination purposes.
 *
 * Created by Karel on 24. 2. 2015.
 */
public class GameRegistry {

    private List<Character> characters;

    private List<Location> locations;

    private List<Item> items;

    private Player player;

    public GameRegistry() {

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

    @Override
    public String toString() {
        return "GameRegistry{" +
                ", characters=" + characters +
                ", locations=" + locations +
                ", items=" + items +
                ", player=" + player +
                '}';
    }

    public Player getPlayer() {
        return player;
    }
}
