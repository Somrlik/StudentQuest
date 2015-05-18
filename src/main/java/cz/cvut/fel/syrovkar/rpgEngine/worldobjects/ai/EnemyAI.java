package cz.cvut.fel.syrovkar.rpgEngine.worldobjects.ai;

import cz.cvut.fel.syrovkar.rpgEngine.Game;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.LivingEntity;
import cz.cvut.fel.syrovkar.rpgEngine.worldobjects.Player;

import java.util.logging.Logger;

/**
 * Created by Karel on 18. 5. 2015.
 */
public class EnemyAI {

    private static final Logger LOG = Logger.getLogger(EnemyAI.class.getName());

    protected LivingEntity itsEntity = null;

    public Player getPlayer() {
        return Game.gameRegistry.getPlayer();
    }

    public LivingEntity getItsEntity() {
        return itsEntity;
    }

    public void setItsEntity(LivingEntity itsEntity) {
        this.itsEntity = itsEntity;
    }

    public void doSomething(double delta) {
        return;
    }

}