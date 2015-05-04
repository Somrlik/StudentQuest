package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

import java.util.logging.Logger;

/**
 * Used for storing drops of an Enemy in game.
 *
 * Created by Karel on 28. 4. 2015.
 */
public class EnemyDrop {

    private static final Logger LOG = Logger.getLogger(EnemyDrop.class.getName());

    private double probability;

    private String drop;

    /**
     * Constructs a new drop
     *
     * @param probability Probability with witch an Item will drop. Ex. 0.12 means 12%
     * @param archetypeId ID of ItemArchetype
     */
    public EnemyDrop(double probability, String archetypeId) {
        this.probability = probability;
        this.drop = archetypeId;

        LOG.finest("New drop: ");
    }

    /**
     * Gets the probability of a drop
     *
     * @return probability
     */
    public double getProbability() {
        return probability;
    }

    /**
     * Gets ItemArchetype ID for this drop
     * @return ID of ItemArchetype
     */
    public String getDropArchetypeId() {
        return drop;
    }

    @Override
    public String toString() {
        return "EnemyDrop{" +
                "probability=" + probability +
                ", drop='" + drop + '\'' +
                '}';
    }
}
