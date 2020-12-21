package objects;

import builds.Factory;

public class Product extends ObjectToBuy {
    public Product() {
        super();
    }

    public Product(String name, Factory fromFactory, double price) {
        super(name, fromFactory, price);
    }

    public boolean equals(Product product) {
        if (product.getFactory() != null && this.getFactory() != null)
            return getName().equals(product.getName()) && getFactory().equals(product.getFactory());
        return getName().equals(product.getName());
    }
}
