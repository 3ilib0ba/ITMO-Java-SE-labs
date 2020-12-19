package allmedia;

import builds.Factory;
import interfaces.WithMassMedia;
import objects.Product;

public class ImportantEvent implements WithMassMedia {
    private String content = "";

    public void eventFactoryAndProduct(Factory factory, Product product, boolean updawn){
        String upOrDawn = "";
        if (!updawn) { upOrDawn = " понизила "; }
        else { upOrDawn = " повысила "; }
        content = factory + upOrDawn + "выпуск продукции " + product;
    }

    @Override
    public void read() {
        System.out.println("Важное событие: " + content);
    }

    @Override
    public void printing(Photography photo) {
        System.out.println("Важное событие по фотографии " + photo);
    }
}
