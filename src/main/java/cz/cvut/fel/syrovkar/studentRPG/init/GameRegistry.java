package cz.cvut.fel.syrovkar.studentRPG.init;

import cz.cvut.fel.syrovkar.studentRPG.archetypes.Character;
import cz.cvut.fel.syrovkar.studentRPG.archetypes.Item;
import cz.cvut.fel.syrovkar.studentRPG.archetypes.Location;

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

    public GameRegistry() {

        characters = new ArrayList<Character>();

        locations = new ArrayList<Location>();

        items = new ArrayList<Item>();

    }

    public void addCharacter(Character character) {

    }

    public void addLocation(Location location) {

    }

    public void addItem(Item item) {

    }

}
