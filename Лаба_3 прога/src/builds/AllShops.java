package builds;

import interfaces.WithStore;
import objects.Product;
import personsandpeoples.Person;

public class AllShops {
    private static final Store[] allShops = new Store[10];

    public static void addShop(Store store) {
        for (int i = 0; i < allShops.length; i++)
            if (allShops[i] == null) {
                allShops[i] = store;
                System.out.println("Добавлен магазин " + store);
                return;
            }
        System.out.println("В городе не может быть так много магазинов");
    }

    public static void getAllShops() {
        for (int i = 0; i < allShops.length; i++)
            if (allShops[i] != null) {
                System.out.println("Магазин " + (i + 1) + " -- " + allShops[i]);
            } else {
                return;
            }
    }

    public static void removeShop(Store removedShop) {
        for (int i = 0; i < allShops.length; i++)
            if (allShops[i] == removedShop) {
                System.out.println("Магазин " + allShops[i] + " прекратил своё существование");
                // далее идем  переносим все ссылки на одну назад
                for (; i < allShops.length - 1; i++) {
                    allShops[i] = allShops[i + 1];
                }
                return;
            }
    }

    public static void addProductAllShops(Product product) {
        for (int i = 0; i < allShops.length && allShops[i] != null; i++) {
            allShops[i].addProduct(product);
        }
    }

    public static void buyProduct(Person person, Product product, int count) {
        for (int i = 0; i < allShops.length && allShops[i] != null; i++) {
            System.out.print("В магазине " + allShops[i] + " ");
            allShops[i].buyProduct(person, product, count);
        }
    }

    public static void removeProduct(Product product){
        for (int j = 0;  j < allShops.length && allShops[j] != null; j++) {
            if (allShops[j].equals(product)){
                System.out.println("Все магазины cбывает(-ют) продукт " + product);
                for (; j < allShops.length - 1; j++) {
                    allShops[j] = allShops[j + 1];
                }
                return;
            }
        }
    }
}