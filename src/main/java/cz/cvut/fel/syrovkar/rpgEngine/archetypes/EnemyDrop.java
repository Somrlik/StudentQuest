package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

/**
 * Used for storing drops of an Enemy in game.
 *
 * Created by Karel on 28. 4. 2015.
 */
public class EnemyDrop {

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
}
