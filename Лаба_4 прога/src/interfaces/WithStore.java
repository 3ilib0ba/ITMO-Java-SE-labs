package interfaces;

import objects.Product;
import personsandpeoples.Person;

public interface WithStore {
    public void addProduct(Product product);
    public void removeProduct(Product product);
    public void buyProduct(Person person, Product product, int count);
}
