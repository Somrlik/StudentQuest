package cz.cvut.fel.syrovkar.rpgEngine.worldobjects.ai;

import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Enemy;

/**
 * Wrapper for all enemy AIs
 *
 * Created by Karel on 18. 5. 2015.
 */
public interface EnemyAI {

    /**
     * BUGGY! DO NOT USE!
     *
     * @return Entity with this AI
     */
    Enemy getItsEntity();

    /**
     * BUGGY! DO NOT USE!
     *
     * @param itsEntity Sets what Entity this AI controls
     */
    void setItsEntity(Enemy itsEntity);

    /**
     * One tick of AI.
     *
     * @param delta Time difference between frames of the Game
     */
    void doSomething(Enemy itsEntity, double delta);

}
