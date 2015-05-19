package cz.cvut.fel.syrovkar.rpgEngine.worldobjects;

import java.util.logging.Logger;

/**
 * Created by Karel on 19. 5. 2015.
 */
public abstract class InteractibleEntity extends Entity {

    private static final Logger LOG = Logger.getLogger(InteractibleEntity.class.getName());

    public InteractibleEntity(String name, String id, double x, double y, double xSize, double ySize) {
        super(name, id, x, y, xSize, ySize);
    }

    @Override
    public boolean isInteractible() {
        return true;
    }

    public void interact(Player player) {

    }

    public void interact(Enemy enemy) {

    }
}
