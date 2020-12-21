package builds;

import interfaces.WithStore;
import objects.Product;
import personsandpeoples.Person;
import data.DayMonth;

public class Store extends Institution implements WithStore {
    private Product[] stock = new Product[10];
    private int i = 0;

    public Store(String name) {
        super(name);
        addProduct(new Product());
        AllShops.addShop(this);
    }

    @Override
    public void addProduct(Product product) {
        if (i < stock.length) {
            stock[i] = product;
            i++;
        } else {
            System.out.println("нет места на складе");
        }
    }

    private void swapInStock(int counter) {
        stock[counter] = null;
        for (; counter < stock.length - 1; counter++)
            stock[counter] = stock[counter + 1];
    }

    @Override
    public void removeProduct(Product product) {
        for (int j = 0; j < stock.length && stock[j] != null; j++) {
            if (stock[j].equals(product)) {
                System.out.println(getName() + " cбывает(-ют) продукт " + product);
                swapInStock(j);
                return;
            }
        }
    }

    @Override
    public void buyProduct(Person person, Product product, int count) {
        // проверка на наличие продукта в магазине
        // ...
        //
        //TODO проверка на наличие у персонажа данной суммы, дописать потом
        double allCost = count * product.getPrice();
//        System.out.println("Покупатель " + person +
//                " приобретает товар " + product +
//                " в количестве " + count +
//                " штук по общей цене " + allCost);
        product.allProceed.addProceed(count);
        product.getFactory().owner.addMoney(allCost);

    }

    public String toString() {
        return getName();
    }
}
