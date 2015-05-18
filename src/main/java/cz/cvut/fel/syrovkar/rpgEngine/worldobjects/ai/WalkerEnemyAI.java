package cz.cvut.fel.syrovkar.rpgEngine.worldobjects.ai;

import java.util.logging.Logger;

/**
 * AI that walks in a circle
 * Created by Karel on 18. 5. 2015.
 */
public class WalkerEnemyAI extends EnemyAI {

    private static final Logger LOG = Logger.getLogger(WalkerEnemyAI.class.getName());

    /**
     * Walkes in a cycle
     */
    public WalkerEnemyAI() {

    }

    @Override
    public void doSomething(double delta) {

        //itsEntity.move(Direction.RIGHT, delta);
    }
}

