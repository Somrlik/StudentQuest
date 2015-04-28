package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Entity;

import java.util.ArrayList;

/**
 * Basic Location class.
 *
 * Created by Karel on 25. 2. 2015.
 */
public class Location {

    String name;
    ArrayList<Entity> entities = new ArrayList<Entity>();

    /**
     * Creates a new location.
     *
     * @param name name of location
     */
    public Location(String name) {
        this.name = name;
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

}
