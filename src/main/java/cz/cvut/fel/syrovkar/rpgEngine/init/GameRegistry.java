package cz.cvut.fel.syrovkar.rpgEngine.init;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.EnemyArchetype;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.ItemArchetype;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.WorldMap;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * This class hold all classes of all actors, mainly for reference and instantination purposes.
 *
 * Created by Karel on 24. 2. 2015.
 */
public class GameRegistry {

    private WorldMap world;

    private List<ItemArchetype> itemsArchetypes;

    private List<EnemyArchetype> enemyArchetypes;

    private Player player;

    //private boolean isReady = false;

    public GameRegistry() {


        itemsArchetypes = new ArrayList<ItemArchetype>();

        enemyArchetypes = new ArrayList<EnemyArchetype>();

        player = new Player(20, 20, 40, 40);

    }

    public void setWorld(WorldMap wm) {
        this.world = wm;
    }

    public WorldMap getWorld() {
        return this.world;
    }

    public void addItemArchetype(ItemArchetype item) {
        itemsArchetypes.add(item);
    }

    public void addEnemyArchetype(EnemyArchetype enemy) {
        enemyArchetypes.add(enemy);
    }

    public Player getPlayer() {
        return player;
    }

    public List<ItemArchetype> getItemsArchetypes() {
        return itemsArchetypes;
    }

    public List<EnemyArchetype> getEnemyArchetypes() {
        return enemyArchetypes;
    }

    @Override
    public String toString() {
        return "GameRegistry{" +
                ", itemsArchetypes=" + itemsArchetypes +
                ", enemyArchetypes=" + enemyArchetypes +
                ", player=" + player +
                '}';
    }
}
