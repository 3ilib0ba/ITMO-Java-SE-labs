package builds.shops;

import builds.shopsexceptions.NegativeCountException;
import interfaces.WithStore;
import objects.Product;
import personsandpeoples.Person;

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
    public void buyProduct(Person person, Product product, int count) throws NegativeCountException {
        // проверка на наличие продукта в магазине
        // ...
        //
        //TODO проверка на наличие у персонажа данной суммы, дописать потом
        if (count <= 0) { // Проверка на покупку положительного числа коврижек
            throw new NegativeCountException("Нельзя купить такое число продукта");
        }
        double allCost = count * product.getPrice();
//        System.out.println("Покупатель " + person +
//                " приобретает товар " + product +
//                " в количестве " + count +
//                " штук по общей цене " + allCost);
        product.allProceed.addProceed(count);
        product.getFactory().getOwner().addMoney(allCost);

    }

    public String toString() {
        return getName();
    }

    public static class AllStories {

    }
}
