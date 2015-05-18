package cz.cvut.fel.syrovkar.rpgEngine.worldobjects;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Attribute;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.EnemyArchetype;

import java.util.logging.Logger;

/**
 * Basic Enemy class.
 *
 * Created by Karel on 24. 2. 2015.
 */
public class Enemy extends LivingEntity {

    private static final Logger LOG = Logger.getLogger(Enemy.class.getName());

    public Enemy(EnemyArchetype archetype, int x, int y, int xSize, int ySize) {
        super(archetype.getName(), archetype.getId(), x, y, xSize, ySize);

        this.setTexture(archetype.getTexture());

        for (Attribute a : archetype.getAttributes()) {
            this.addAttribute(a.getName(), a.getValue());
        }

    }


}
