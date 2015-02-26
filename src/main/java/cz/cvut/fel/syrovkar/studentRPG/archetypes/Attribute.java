package cz.cvut.fel.syrovkar.studentRPG.archetypes;

/**
 * Attribute serves as a container for different properties of actors and entities.
 *
 * It is defined as a pair of 'name' and 'value'. 'value' can be of any type.
 *
 * The name of an Attribute is unique, therefore attribute named 'Foo' equals to other attribute named 'Foo'.
 *
 * Created by Karel on 23. 2. 2015.
 */
public class Attribute {

    private String name;

    private Object value;

    /**
     * Constructs an Attribute
     *
     * @param name  Name of attribute
     * @param value Value of attribute
     */
    public Attribute(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    /**
     * @return Value of attribute
     */
    public Object getValue() {
        return value;
    }

    /**
     * Changes value of attribute
     *
     * @param value New value of attribute
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * @return Name of attribute
     */
    public String getName() {
        return name;
    }

    /**
     * Changes name of attribute
     *
     * @param name New name of attribute
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "name='" + name + '\'' +
                ", value=" + value.toString() +
                '}';
    }

    /**
     * Attribute with 'name' equals to other attribute with the same name.
     * For comparison of values, use getValueByAttrName()
     *
     * @param o What to compare with
     * @return If they are equal true, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attribute attribute = (Attribute) o;

        return name.equals(attribute.name);

    }

    /**
     * Basic String hashcode
     *
     * @return String hashcode
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

}
