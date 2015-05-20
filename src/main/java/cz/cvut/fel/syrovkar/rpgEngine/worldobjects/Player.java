package cz.cvut.fel.syrovkar.rpgEngine.worldobjects;

import cz.cvut.fel.syrovkar.rpgEngine.Game;
import cz.cvut.fel.syrovkar.rpgEngine.Inventory;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.ItemArchetype;

import java.util.logging.Logger;

/**
 * Player class.
 *
 * Created by Karel on 26. 2. 2015.
 */
public class Player extends LivingEntity {

    private static final Logger LOG = Logger.getLogger(Player.class.getName());

    private Inventory inventory;

    public Player(int x, int y, int xSize, int ySize) {
        super("Player", "player", x, y, xSize, ySize);
        inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void addToInventory(ItemArchetype ia) {
        inventory.addItem(ia);
    }

    public void removeFromInventory(ItemArchetype ia) {
        inventory.removeItem(ia);
    }

    public boolean isInInventory(String iaId) {
        return inventory.isInInventory(iaId);
    }

    /*@Override
    public void move(Direction direction, double delta) {
        this.direction = direction;
        switch (direction) {
            case UP:
                yVelocity = -64;
                break;
            case DOWN:
                yVelocity = 64;
                break;
            case LEFT:
                xVelocity = -64;
                break;
            case RIGHT:
                xVelocity = 64;
                break;
        }

        LOG.finest("Moving player from x:" + x + " y:" + y + "with Xspeed: " + xVelocity + " Yspeed: " + yVelocity);

        this.hitbox.setX((int) this.getX());
        this.hitbox.setY((int) this.getY());

    }*/

    @Override
    public boolean collideWith(Entity e, double delta) {
        if (super.collideWith(e, delta)) {

            LOG.fine("Player collided with " + e.getId());
            LOG.finer("Original Player's x: " + x + " y:" + y);

            // TODO: Fix getting stuck in entities

            x += -((xVelocity * 4) * delta);
            y += -((yVelocity * 4) * delta);

            xVelocity = yVelocity = 0;

            this.hitbox.setX(x);
            this.hitbox.setY(y);

            //xVelocity = yVelocity = 0;

            LOG.finer("New Player's x: " + x + " y: " + y);

            if (e.isInteractible()) {
                ((InteractibleEntity) e).interact(this);
            }

            return true;
        }
        return false;
    }

    /**
     * Detects collisions between Player and Items
     *
     * @param i     Item to collide with
     * @param delta Time difference between two frames of the Game
     * @return True if collides, false otherwise
     */
    public boolean collideWith(Item i, double delta) {
        if (super.collideWith(i, delta)) {

            LOG.fine("Player collided with " + i.getId());

            Game.gameRegistry.getPlayer().addToInventory(Game.gameRegistry.getItemArchetypeById(i.getId()));

            i.destroy();

            return true;
        }

        return false;
    }

    public void attack(double delta) {
        int damage = 0;
        damage += Integer.parseInt(getValueByAttrName("Attack"));
        for (ItemArchetype ia : inventory.getItemArchetypes()) {
            if (ia.getValueByAttrName("Attack") != null) {
                damage += Integer.parseInt(ia.getValueByAttrName("Attack"));
            }
        }
        HurtingEntity hurt = new HurtingEntity("Attacking Entity", this.getId() + this.getName() + "sHurtEntity", (int) x, (int) y, 20, 20, damage);

    }

}
