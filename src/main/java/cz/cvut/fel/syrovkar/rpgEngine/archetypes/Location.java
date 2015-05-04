package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Enemy;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Entity;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Item;

import java.util.ArrayList;

/**
 * Location holds all:
 *  - entities (static object)
 *  - enemies (enemies)
 *  - items (on the ground)
 *
 *  And provides them for rendering and updates of game logic.
 *
 * Location is defined by an unique id.
 *
 * Created by Karel on 25. 2. 2015.
 */
public class Location {

    String name;

    String id;

    ArrayList<Entity> entities = new ArrayList<Entity>();

    ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    ArrayList<Item> items = new ArrayList<Item>();

    boolean isPlayerHere = false;

    /**
     * Creates a new location.
     *
     * @param name name of Location
     * @param id unique id of Location
     */
    public Location(String name, String id) {
        this.name = name;
        this.id = id;
    }

    /**
     * @return All entities in current location
     */
    public ArrayList<Entity> getEntities() {
        return entities;
    }

    /**
     * @return All enemies in current location
     */
    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    /**
     * @return All item laying on the ground
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Adds Entity to the Location
     *
     * @param e Entity to add
     */
    public void addEntity(Entity e) {
        this.entities.add(e);
    }

    /**
     * Adds an Enemy into the Location
     *
     * @param e Enemy to add
     */
    public void addEnemy(Enemy e) {
        this.enemies.add(e);
    }

    /**
     * Adds an Item to this Location
     * @param i Item to add
     */
    public void addItem(Item i) {
        this.items.add(i);
    }

    /**
     * @return A nice name of this Location
     */
    public String getName() {
        return name;
    }

    /**
     * @return An unique ID of this location
     */
    public String getId() {
        return id;
    }

    /**
     * @return True if Player is currently in this Location
     */
    public boolean isPlayerHere() {
        return isPlayerHere;
    }

    /**
     * Places the Player in this location
     *
     * @param isPlayerHere True if you want to Player to enter, false otherwise
     */
    public void setIsPlayerHere(boolean isPlayerHere) {
        this.isPlayerHere = isPlayerHere;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", entities=" + entities +
                ", enemies=" + enemies +
                ", items=" + items +
                '}';
    }
}
