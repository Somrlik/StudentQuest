package cz.cvut.fel.syrovkar.rpgEngine.worldobjects;

import cz.cvut.fel.syrovkar.rpgEngine.Game;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Attribute;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.EnemyArchetype;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.EnemyDrop;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.ItemArchetype;
import cz.cvut.fel.syrovkar.rpgEngine.init.GameRegistry;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.ai.EnemyAI;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Basic Enemy class.
 * <p/>
 * Created by Karel on 24. 2. 2015.
 */
public class Enemy extends LivingEntity {

    private static final Logger LOG = Logger.getLogger(Enemy.class.getName());

    private EnemyAI itsAi;

    private EnemyArchetype archetype = null;

    public Enemy(EnemyArchetype archetype, int x, int y, int xSize, int ySize) {
        super(archetype.getName(), archetype.getId(), x, y, xSize, ySize);

        this.archetype = archetype;

        this.setTexture(archetype.getTexture());

        for (Attribute a : archetype.getAttributes()) {
            this.addAttribute(a.getName(), a.getValue());
        }

        itsAi = archetype.getItsAI();

        itsAi.setItsEntity(this);

    }

    public EnemyAI getItsAi() {
        return itsAi;
    }

    /**
     * Constructs items to drop after the death of the Enemy
     *
     * @return List of ItemArchetypes to drop on the ground
     */
    public List<ItemArchetype> makeDrops() {
        ArrayList<ItemArchetype> ret = new ArrayList<ItemArchetype>();
        for (EnemyDrop ed : archetype.getDrops()) {
            if (Math.random() >= ed.getProbability())
                ret.add(Game.gameRegistry.getItemArchetypeById(ed.getDropArchetypeId()));
        }
        return ret;
    }

    /**
     * Update AI of this Enemy
     *
     * @param delta Time difference between two frames fo the Game
     */
    public void updateAI(double delta) {
        itsAi.doSomething(this, delta);
        if ("0".equals(this.getValueByAttrName("Health"))) {
            this.die();
        }
    }

    /**
     * Called upon death of the Enemy
     */
    public void die() {
        List<Enemy> enemies = new ArrayList<Enemy>();
        enemies.add(this);
        GameRegistry.enemiesToDelete = enemies;

        List<ItemArchetype> drops = makeDrops();
        if (!drops.isEmpty()) {
            for (ItemArchetype drop : drops) {
                Game.currentLocation.addItem(new Item(Game.gameRegistry.getItemArchetypeById(drop.getId()), (int) this.getX(), (int) this.getY(), 40, 40));
            }
        }

    }

}
