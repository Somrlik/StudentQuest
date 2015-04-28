package cz.cvut.fel.syrovkar.rpgEngine.archetypes;

/**
 * Created by Karel on 28. 4. 2015.
 */
public class EnemyDrop {

    private double probability;

    private String drop;

    public EnemyDrop(double probability, String archetypeId) {
        this.probability = probability;
        this.drop = archetypeId;
    }

    public double getProbability() {
        return probability;
    }

    public String getDropArchetypeId() {
        return drop;
    }
}
