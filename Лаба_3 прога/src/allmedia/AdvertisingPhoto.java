package allmedia;

import objects.Product;
import personsandpeoples.Person;

public class AdvertisingPhoto extends Photography {
    AdvertisingPhoto() {
        super();
    }

    public AdvertisingPhoto(Person person, Product product) {
        super("" + person + " рекламирует продукт " + product);
    }
}
