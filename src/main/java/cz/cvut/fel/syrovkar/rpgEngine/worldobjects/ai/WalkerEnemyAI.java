package cz.cvut.fel.syrovkar.rpgEngine.worldobjects.ai;

import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Direction;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Enemy;

import java.util.logging.Logger;

/**
 * AI that walks in a circle
 * Created by Karel on 18. 5. 2015.
 */
public class WalkerEnemyAI implements EnemyAI {

    Enemy itsEntity = null;

    private static final Logger LOG = Logger.getLogger(WalkerEnemyAI.class.getName());

    int walkX = 100;
    int walkY = 100;

    double alreadyMoved = 0;

    double x = 0;

    double y = 0;

    /**
     * Walkes in a cycle
     */
    public WalkerEnemyAI() {
    }

    @Override
    public Enemy getItsEntity() {
        return itsEntity;
    }

    @Override
    public void setItsEntity(Enemy itsEntity) {
        this.itsEntity = itsEntity;
    }

    @Override
    public void doSomething(Enemy itsEntity, double delta) {

        if (itsEntity.getY() > alreadyMoved++) {
            itsEntity.move(Direction.UP, delta);
        } else {
            itsEntity.move(Direction.DOWN, delta);
            alreadyMoved--;
        }

    }
}

