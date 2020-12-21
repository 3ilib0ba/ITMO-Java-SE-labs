package builds;

import personsandpeoples.Person;

public class Factory {
    private final String name;
    TypeFactory product;
    Person owner;

    public Factory(String name, TypeFactory type, Person owner) {

        this.name = name;
        this.product = type;
        this.owner = owner;
    }

    public boolean equals(Factory factory) {
        return this.name.equals(factory.name);
    }

    public String toString() {
        if (product == TypeFactory.CANDY) {
            return "(конфетная фабрика " + name + ")";
        } else if (product == TypeFactory.BAKERY) {
            return "(пекарня " + name + ")";
        } else {
            return name;
        }
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Person getOwner() {
        return owner;
    }
}
