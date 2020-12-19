package builds;

import objects.Product;

public abstract class Institution {
    private String name;

    public Institution(String name){
        this.name = name;
    }

    public void setName(String name) { this.name = name; }
    public String getName() { return name;}
}
