package cz.cvut.fel.syrovkar.rpgEngine.init;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.EnemyArchetype;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.ItemArchetype;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.WorldMap;
import cz.cvut.fel.syrovkar.rpgEngine.gui.Overlay;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Enemy;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Item;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * This class hold all Archetypes, mainly for reference and instantination purposes.
 *
 * Never invoke this more than one time.
 *
 * Created by Karel on 24. 2. 2015.
 */
public class GameRegistry {

    private static final Logger LOG = Logger.getLogger(GameRegistry.class.getName());

    public static volatile boolean isLoaded = false;

    private WorldMap world;

    private List<ItemArchetype> itemsArchetypes;

    private List<EnemyArchetype> enemyArchetypes;

    private List<Overlay> overlays;

    private Player player;

    public static List<Item> itemsToDelete = null;

    public static List<Enemy> enemiesToDelete = null;

    /**
     * Do not use.
     */
    public GameRegistry() {

        itemsArchetypes = new ArrayList<ItemArchetype>();

        enemyArchetypes = new ArrayList<EnemyArchetype>();

        overlays = new ArrayList<Overlay>();

        player = new Player(20, 20, 40, 40);

    }

    /**
     * Sets the WorldMap (wrapper for locations)
     *
     * @param wm New WorldMap
     */
    public void setWorld(WorldMap wm) {
        this.world = wm;
    }

    /**
     * @return This WorldMap
     */
    public WorldMap getWorld() {
        return this.world;
    }

    /**
     * Adds new ItemArchetype to the registry
     *
     * @param item ItemArchetype to be added
     */
    public void addItemArchetype(ItemArchetype item) {
        itemsArchetypes.add(item);
    }

    /**
     * Adds new EnemyArchetype to the registry
     * @param enemy EnemyArchetype to be added
     */
    public void addEnemyArchetype(EnemyArchetype enemy) {
        enemyArchetypes.add(enemy);
    }

    /**
     * @return The Player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @return All ItemArchetypes
     */
    public List<ItemArchetype> getItemsArchetypes() {
        return itemsArchetypes;
    }

    /**
     * @return All EnemyArchetypes
     */
    public List<EnemyArchetype> getEnemyArchetypes() {
        return enemyArchetypes;
    }

    /**
     * @param id Id of ItemArchetype
     * @return Registered ItemArchetype with said id
     */
    public ItemArchetype getItemArchetypeById(String id) {
        for (ItemArchetype ia : itemsArchetypes) {
            if (ia.getId().equals(id)) return ia;
        }
        return null;
    }

    public void addOverlay(Overlay overlay) {
        overlays.add(overlay);
    }

    public List<Overlay> getOverlays() {
        return overlays;
    }

    @Override
    public String toString() {
        return "GameRegistry{" +
                "world=" + world +
                ", itemsArchetypes=" + itemsArchetypes +
                ", enemyArchetypes=" + enemyArchetypes +
                ", player=" + player +
                '}';
    }
}
