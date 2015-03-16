package cz.cvut.fel.syrovkar.rpgEngine;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Character;
import cz.cvut.fel.syrovkar.rpgEngine.utils.CanCombat;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Basic Player class.
 * <p/>
 * Created by Karel on 26. 2. 2015.
 */
public class Player extends Character implements CanCombat {

    public Player() {
        super("Player");
    }

    @Override
    public void fight() {
        throw new NotImplementedException();
    }

    @Override
    public void takeDamage() {
        throw new NotImplementedException();
    }

    @Override
    public void doDamage() {
        throw new NotImplementedException();
    }

    @Override
    public void fleeFromCombat() {
        throw new NotImplementedException();
    }

    @Override
    public void useAbility() {
        throw new NotImplementedException();
    }

    @Override
    public void equipItem() {
        throw new NotImplementedException();
    }

    @Override
    public void unequipItem() {
        throw new NotImplementedException();
    }

}
