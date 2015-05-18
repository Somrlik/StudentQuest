package cz.cvut.fel.syrovkar.rpgEngine.worldobjects.ai;

import cz.cvut.fel.syrovkar.rpgEngine.Game;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.LivingEntity;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Player;

import java.util.logging.Logger;

/**
 * Wrapper for all enemy AIs
 *
 * Created by Karel on 18. 5. 2015.
 */
public class EnemyAI {

    private static final Logger LOG = Logger.getLogger(EnemyAI.class.getName());

    protected LivingEntity itsEntity = null;

    /**
     * @return player from gameRegistry
     */
    public Player getPlayer() {
        return Game.gameRegistry.getPlayer();
    }

    /**
     * @return Entity with this AI
     */
    public LivingEntity getItsEntity() {
        return itsEntity;
    }

    /**
     * @param itsEntity Sets what Entity this AI controls
     */
    public void setItsEntity(LivingEntity itsEntity) {
        this.itsEntity = itsEntity;
    }

    /**
     * One tick of AI.
     *
     * @param delta Time difference between frames of the Game
     */
    public void doSomething(double delta) {

    }

}
