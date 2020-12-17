package objects;

import builds.Factory;

public class Product {
    private String name;
    private Factory fromFactory;
    private double price;
    public ProceedsAndEstimate allProceed = new ProceedsAndEstimate();

    public Product(){
        name = "залежалый товар";
        price = 0.1;
        allProceed.setPrice(price);
    }
    public Product(String name, Factory fromFactory, double price){
      this.name = name;
      this.fromFactory = fromFactory;
      this.price = price;
      allProceed.setPrice(price);
    }

    public Factory getFactory(){ return fromFactory; }

    public boolean equals(Product product){
        if (product.fromFactory != null && this.fromFactory != null)
            return this.name.equals(product.name) && this.fromFactory.equals(product.fromFactory);
        return this.name.equals(product.name);
    }

    public double getPrice(){
        return this.price;
    }

    public String toString() {
        if (fromFactory != null)
            return this.name + " " + this.fromFactory;
        return this.name;
    }
}
