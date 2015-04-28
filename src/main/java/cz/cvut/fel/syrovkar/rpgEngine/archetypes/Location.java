package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

import cz.cvut.fel.syrovkar.rpgEngine.Enemy;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Entity;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Item;

import java.util.ArrayList;

/**
 * Basic Location class.
 *
 * Created by Karel on 25. 2. 2015.
 */
public class Location {

    String name;

    String id;

    ArrayList<Entity> entities = new ArrayList<Entity>();

    ArrayList<Enemy> enemies;

    ArrayList<Item> items;

    /**
     * Creates a new location.
     *
     * @param name name of location
     */
    public Location(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addEntity(Entity e) {
        this.entities.add(e);
    }

    public void addEnemy(Enemy e) {
        this.enemies.add(e);
    }

    public void addItem(Item i) {
        this.items.add(i);
    }
}
