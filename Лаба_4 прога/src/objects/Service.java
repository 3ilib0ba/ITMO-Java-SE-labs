package objects;

import builds.Factory;

public class Service extends ObjectToBuy {

    public Service(String name, Factory fromFactory, double price) {
        super(name, fromFactory, price);
    }

    public boolean equals(Service service) {
        if (service.getFactory() != null && this.getFactory() != null)
            return getName().equals(service.getName()) && getFactory().equals(service.getFactory());
        return getName().equals(service.getName());
    }
}
