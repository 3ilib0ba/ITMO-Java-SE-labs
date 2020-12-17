package personsandpeoples;

import builds.Factory;

public class FactoryOwner extends Person{
    Factory myFactory;
    public FactoryOwner(){
        super();
        super.setName("Владелец фабрики");
    }

}
