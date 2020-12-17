package allmedia;

import interfaces.WithMassMedia;

public class Magazine implements WithMassMedia {
    private String name;
    private String heading;
    private String body;
    private final Photography[] inBody = new Photography[5];
    private int i = 0;

    Magazine() {
        this.name = "";
        this.heading = "";
        this.body = "";
    }

    public Magazine(String toAllHead, String toAllBody) {
        this.name = "все газеты";
        this.heading = toAllHead;
        this.body = toAllBody;
    }

    Magazine(String name, String heading, String body) {
        this.name = name;
        this.heading = heading;
        this.body = body;
    }

    public void readHeading() {
        System.out.println("Заголовок: " + heading);
    }

    public void readBody() {
        System.out.println("Информация: " + body);
        for (int i = 0; i < inBody.length; i++) {
            if (inBody[i] != null)
                System.out.println("Фото №" + (i + 1) + ": " + inBody[i]);
        }
    }

    @Override
    public void read() {
        System.out.println();
        System.out.println("Тип газеты: " + name);
        readHeading();
        readBody();
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
