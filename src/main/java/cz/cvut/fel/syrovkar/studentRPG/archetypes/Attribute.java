package cz.cvut.fel.syrovkar.studentRPG.archetypes;

/**
 * Created by Karel on 23. 2. 2015.
 */
public class Attribute {

    private String name;

    private Object attribute;

    public Attribute(String name, Object attribute) {
        this.name = name;
        this.attribute = attribute;
    }

    public Object getAttribute() {
        return attribute;
    }

    public void setAttribute(Object attribute) {
        this.attribute = attribute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "name='" + name + '\'' +
                ", attribute=" + attribute.toString() +
                '}';
    }
}
