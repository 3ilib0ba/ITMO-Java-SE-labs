package allmedia;

import interfaces.WithMassMedia;

public class VisiblePlaces implements WithMassMedia {
    private final Photography[] inBody = new Photography[10];
    private int i = 0;

    @Override
    public void read() {
        for (int i = 0; i < inBody.length; i++){
            if (inBody[i] != null)
                System.out.println("Фото №" + (i + 1) + ": " + inBody[i]);
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
