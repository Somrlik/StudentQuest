package cz.cvut.fel.syrovkar.rpgEngine.utils;

/**
 * Basic fighting class.
 * <p/>
 * Created by Karel on 27. 2. 2015.
 */
public interface CanCombat {

    public void fight();

    public void takeDamage();

    public void doDamage();

    public void fleeFromCombat();

    public void useAbility();

    public void equipItem();

    public void unequipItem();

}
