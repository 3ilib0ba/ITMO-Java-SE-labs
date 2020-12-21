package objects;

import builds.Factory;

public abstract class ObjectToBuy {
    private String name;
    private Factory fromFactory;
    private double price;
    public ProceedsAndEstimate allProceed = new ProceedsAndEstimate();

    public ObjectToBuy(){
        name = "залежалый товар";
        price = 0.1;
        allProceed.setPrice(price);
    }

    public ObjectToBuy(String name, Factory fromFactory, double price){
        this.name = name;
        this.fromFactory = fromFactory;
        this.price = price;
        allProceed.setPrice(price);
    }

    public Factory getFactory(){ return fromFactory; }
    public double getPrice(){
        return price;
    }
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
    public void setFromFactory(Factory factory) { this.fromFactory = factory; }
    public void setPrice(double price) { this.price = price; }

    public String toString() {
        if (fromFactory != null)
            return this.name + " " + this.fromFactory;
        return this.name;
    }
}
