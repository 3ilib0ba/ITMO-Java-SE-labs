package allmedia;

import interfaces.WithMassMedia;

public class VisiblePlaces implements WithMassMedia {
    private final Photography[] inBody = new Photography[10];
    private int i = 0;

    @Override
    public void read() {
        for (int i = 0; i < inBody.length; i++){
            if (inBody[i] != null)
                if (inBody[i].getClass().equals(Photography.class))
                    System.out.println("Фото №" + (i + 1) + ": " + inBody[i]);
                else if (inBody[i].getClass().equals(Photography.AdvertisingPhoto.class)){
                    System.out.println(inBody[i]);
                }
        }
    }

    @Override
    public void printing(Photography photo) {
        if (i <= 9) {
            inBody[i] = photo;
            i++;
        } else {
            System.out.println("Нет места под фотографию");
        }
    }
}
