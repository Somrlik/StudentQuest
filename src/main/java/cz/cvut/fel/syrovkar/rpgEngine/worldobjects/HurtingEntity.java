package cz.cvut.fel.syrovkar.rpgEngine.worldobjects;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Attribute;

import java.util.logging.Logger;

/**
 * Entity that hurts others.
 * <p/>
 * Created by Karel on 19. 5. 2015.
 */
public class HurtingEntity extends LivingEntity {

    private static final Logger LOG = Logger.getLogger(HurtingEntity.class.getName());

    private int damage = 0;

    public HurtingEntity(String name, String id, int x, int y, int xSize, int ySize, int damage) {
        super(name, id, x, y, xSize, ySize);
        this.damage = damage;
    }

    public boolean collideWith(LivingEntity e, double delta) {
        if (super.collideWith(e, delta)) {
            hurt(e);
            return true;
        }
        return false;
    }

    public void hurt(LivingEntity e) {
        int health = Integer.parseInt(e.getValueByAttrName("Health"));
        health = health - damage;
        if (health > 0) health = 0;
        for (Attribute atr : e.getAttributes()) {
            if ("Health".equals(atr.getName())) {
                atr.setValue(Integer.toString(health));
            }
        }
    }

}
