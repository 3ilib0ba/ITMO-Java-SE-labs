import allmedia.*;
import builds.*;
import cities.Davilon;
import data.DayMonth;
import objects.Product;
import personsandpeoples.*;

public class Laba {
    public static void main(String[] args) {
        DayMonth.nextMoyth();
        DayMonth.nextDay();
        Davilon davilon = new Davilon();
        Aboriginal peoples = new Aboriginal(davilon);
        //Peoples.addMoney(100000000);
        FactoryOwner dawnOwner = new FactoryOwner();
        Factory dawn = new Factory("Заря", Typefactory.CANDY, dawnOwner);
        Dunno dunno = new Dunno("Незнайка", "лунный город " + davilon, "скафандр");
        Product honeyCake = new Product("коврижка", dawn, 25);

        Magazine allMagazines = new Magazine("Космические гости",
                "В лунный город Давилон прибыл космический путешественник");
        allMagazines.read();

        Photography p1 = new Photography("Незнайка вылезает из автомашины");
        Photography p2 = new Photography("Незнайка вылез из автомашины!");
        Photography p3 = new Photography("Незнайка прибыл в гостиницу");

        VisiblePlaces allPlaces = new VisiblePlaces();
        allPlaces.printing(p1);
        allPlaces.printing(p2);
        allPlaces.printing(p3);
        AdvertisingPhoto ad1 = new AdvertisingPhoto(dunno, honeyCake);
        allPlaces.printing(ad1);
        allPlaces.read();

        Store Apple = new Store("магазин Apple");
        Store Amazon = new Store("магазин Amazon");
        AllShops.getAllShops();
        AllShops.addProductAllShops(honeyCake);
        AllShops.buyProduct(peoples, honeyCake, 50);
        if (honeyCake.allProceed.getCount(DayMonth.month, DayMonth.month) > 100) {
            System.out.println("Местные жители едят только коврижки, местным " +
                                "магазинам имеет смысл продавать только их");
        }
        AllShops.removeProduct(new Product());

        int countOfMonth = 0;
        for (int i = 1; i <= 29; i++) {
            countOfMonth += honeyCake.allProceed.getCount(DayMonth.month - 1, i);
        }
        if (honeyCake.allProceed.getCount(DayMonth.month, DayMonth.day) > countOfMonth) {
            System.out.println("За день было продано коврижек столько, " +
                    "сколько не было продано за весь прошлый месяц");
        }
    }
}
