package builds;

import personsandpeoples.Person;

public class Factory {
    private String name;
    Typefactory type;
    Person owner;

    public Factory(String name, Typefactory type, Person owner){
        this.name = name;
        this.type = type;
        this.owner = owner;
    }

    public boolean equals(Factory factory) {
        return this.name.equals(factory.name);
    }

    public String toString(){
        if (type == Typefactory.CANDY){
            return "(конфетная фабрика " + name + ")";
        } else if (type == Typefactory.BAKERY){
            return "(пекарня " + name + ")";
        } else {
            return name;
        }
    }
}
