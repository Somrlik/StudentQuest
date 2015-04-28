package cz.cvut.fel.syrovkar.rpgEngine.worldobjects;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Attribute;
import cz.cvut.fel.syrovkar.rpgEngine.gui.Drawable;
import cz.cvut.fel.syrovkar.rpgEngine.utils.AttribHelper;
import cz.cvut.fel.syrovkar.rpgEngine.utils.CanHaveAttributes;

import java.awt.*;
import java.util.HashSet;

/**
 * Created by Karel on 24. 3. 2015.
 */
public class Entity implements Drawable, CanHaveAttributes {

    private final String name;

    private final String id;

    protected double x;
    protected double y;

    protected double xSize;
    protected double ySize;

    protected boolean collides = false;

    protected boolean hasTexture = false;

    protected Image texture = null;

    private HashSet<Attribute> attributes;

    public Entity(String name, String id, double x, double y, double xSize, double ySize) {
        this.name = name;
        this.id = id;
        this.x = x;
        this.y = y;
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public void draw(Graphics g, double delta) {
        g.fillRect((int) x, (int) y, (int) xSize, (int) ySize);
        g.drawString("Entity on " + x + y, (int) x, (int) y);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getxSize() {
        return xSize;
    }

    @Override
    public void setxSize(double xSize) {
        this.xSize = xSize;
    }

    @Override
    public double getySize() {
        return ySize;
    }

    @Override
    public void setySize(double ySize) {
        this.ySize = ySize;
    }

    @Override
    public boolean hasTexture() {
        return this.hasTexture;
    }

    public void setTexture(Image tex) {
        texture = tex.getScaledInstance((int) this.xSize, (int) this.ySize, Image.SCALE_DEFAULT);
        System.out.println("Loaded texture for " + this.getId());
        this.hasTexture = true;
    }

    public boolean collides() {
        return collides;
    }

    public void setCollides(boolean collides) {
        this.collides = collides;
    }

    @Override
    public HashSet<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public Object getValueByAttrName(String name) {
        return AttribHelper.getValueByAttrName(this, name);
    }

    @Override
    public void setValueByAttrName(String name, Object value) {
        AttribHelper.setValueByAttrName(this, name, value);
    }

    @Override
    public void addAttribute(String name, Object value) {
        AttribHelper.addAttribute(this, name, value);
    }

    @Override
    public void removeAttribute(String name) {
        AttribHelper.removeAttribute(this, name);
    }

    @Override
    public boolean hasAttribute(String name) {
        return AttribHelper.hasAttribute(this, name);
    }


}
