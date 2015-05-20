package cz.cvut.fel.syrovkar.rpgEngine.worldobjects.ai;

import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Enemy;

import java.util.logging.Logger;

import static cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Direction.DOWN;
import static cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Direction.UP;

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

        if (alreadyMoved < walkX) {
            itsEntity.move(UP, delta);
            alreadyMoved++;
        } else if (-alreadyMoved > walkX) {
            itsEntity.move(DOWN, delta);
            alreadyMoved--;
        } else {
            alreadyMoved = 0;
        }


    }
}

