package cz.cvut.fel.syrovkar.rpgEngine.worldobjects;

import cz.cvut.fel.syrovkar.rpgEngine.archetypes.Attribute;
import cz.cvut.fel.syrovkar.rpgEngine.archetypes.CollisionBox;
import cz.cvut.fel.syrovkar.rpgEngine.gui.Drawable;
import cz.cvut.fel.syrovkar.rpgEngine.utils.AttribHelper;
import cz.cvut.fel.syrovkar.rpgEngine.utils.CanHaveAttributes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.logging.Logger;

/**
 * This is an all encompassing general class for everything on the Canvas.
 *
 * This class is used for static things on the Canvas.
 *
 * Displaying one Entity by itslef  on the screen is a great feat, it is usually easier to just edit the .xml files.
 *
 * For more info on how to edit such a xml file, see "examples/".
 *
 * Created by Karel on 24. 3. 2015.
 */
public class Entity implements Drawable, CanHaveAttributes {

    private static final Logger LOG = Logger.getLogger(Entity.class.getName());

    private final String name;

    private final String id;

    protected double x;
    protected double y;

    protected double xSize;
    protected double ySize;

    protected boolean collides = false;

    protected boolean hasTexture = false;

    protected BufferedImage texture = null;

    private HashSet<Attribute> attributes = new HashSet<Attribute>();

    protected CollisionBox hitbox = null;

    /**
     * Cosntructs a new Entity.
     *
     * @param name  Its name
     * @param id    ID of the entity
     * @param x     its x coordinate
     * @param y     its y coordinate
     * @param xSize its x size
     * @param ySize its y size
     */
    public Entity(String name, String id, double x, double y, double xSize, double ySize) {
        this.name = name;
        this.id = id;
        this.x = x;
        this.y = y;
        this.xSize = xSize;
        this.ySize = ySize;

        this.hitbox = new CollisionBox(x, y, xSize, ySize);
    }

    /**
     * @return The name of entity
     */
    public String getName() {
        return name;
    }

    /**
     * @return An Unique ID
     */
    public String getId() {
        return id;
    }

    @Override
    public void draw(Graphics g, double delta) {

        if (hasTexture) {
            g.drawImage(texture, (int) x, (int) y, (int) xSize, (int) ySize, null);
        } else g.fillRect((int) x, (int) y, (int) xSize, (int) ySize);

        //g.drawString("Entity on " + x + y, (int) x, (int) y);
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

    /**
     * Sets texure for this Entity and then resizes it to fit the bounding box.
     *
     * @param tex Texture
     */
    public void setTexture(Image tex) {
        if (tex == null) {
            LOG.warning("Failed to load texture for " + this.getId());
            return;
        }

        BufferedImage bimage = new BufferedImage(tex.getWidth(null), tex.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(tex, 0, 0, null);
        bGr.dispose();

        LOG.finer("Loaded texture for " + this.getId());
        this.hasTexture = true;

        texture = bimage;
    }

    /**
     * @return True if collision is on, false otherwise
     */
    public boolean collides() {
        return collides;
    }

    /**
     * Sests collision
     * @param collides True if you want collision, false otherwise
     */
    public void setCollides(boolean collides) {
        this.collides = collides;
    }

    public boolean collideWith(Entity e) {
        return false;
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

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", xSize=" + xSize +
                ", ySize=" + ySize +
                ", collides=" + collides +
                ", hasTexture=" + hasTexture +
                ", texture=" + texture +
                ", attributes=" + attributes +
                '}';
    }
}
