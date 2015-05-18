package cz.cvut.fel.syrovkar.rpgEngine.worldobjects.ai;

import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Direction;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.LivingEntity;

import java.util.logging.Logger;

/**
 * Created by Karel on 18. 5. 2015.
 */
public class WalkerEnemyAI extends EnemyAI {

    private static final Logger LOG = Logger.getLogger(WalkerEnemyAI.class.getName());

    public WalkerEnemyAI(LivingEntity itsEntity) {
        super(itsEntity);
    }

    @Override
    public void doSomething(double delta) {
        itsEntity.move(Direction.RIGHT, delta);
    }
}
