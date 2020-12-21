import allmedia.*;
import builds.*;
import builds.shops.AllShops;
import builds.shops.Store;
import cities.Davilon;
import data.DayMonth;
import builds.shopsexceptions.NegativeCountException;
import interfaces.WithDrSyringe;
import objects.ProceedsAndEstimate;
import objects.Product;
import personsandpeoples.*;

public class Laba {
    public static void deal(Person buyer, double price, Person seller) {
        buyer.setMoney(buyer.getMoney() - price);
        seller.setMoney(seller.getMoney() + price);
    }

    public static void main(String[] args) throws NegativeCountException {
        DayMonth.nextMoyth();
        DayMonth.nextDay();
        Davilon davilon = new Davilon();
        Human[] casualHumans = new Human[Human.AllPeoplesInCity.getPopulation()];
        for (int i = 0; i < casualHumans.length; i++) {
            casualHumans[i] = new Human();
        }
        FactoryOwner dawnOwner = new FactoryOwner("Владелец фабрики Заря");
        Factory dawn = new Factory("Заря", TypeFactory.CANDY, dawnOwner);

        WithDrSyringe DrSyringe = new WithDrSyringe() {
            private double price = 100.0;
            private final Human doctor = new Human("Доктор Шприц");
            String street = "Холерная улица";
            public ProceedsAndEstimate allProceed = new ProceedsAndEstimate();

            public void treatment(Person person) {
                switch (person.getHealthType()) {
                    case VERYBAD:
                        person.setHealthType(HealthType.NORMAL);
                        deal(person, price * 2, doctor);
                        break;
                    case BAD:
                        person.setHealthType(HealthType.NORMAL);
                        deal(person, price, doctor);
                        break;
                    case NORMAL:
                        person.setHealthType(HealthType.GOOD);
                        deal(person, price, doctor);
                        break;
                    case GOOD:
                        person.setHealthType(HealthType.VERYGOOD);
                        deal(person, price, doctor);
                        break;
                    default:
                        System.out.println("Доктор не смог помочь или помогать не надо");
                        deal(person, price * 0.1, doctor);
                }
                allProceed.addProceed(1);
            }

            public Person getPerson() {
                return doctor;
            }

            public void setPrice(double price) {
                if (price > this.price) {
                    System.out.println(doctor + ": цена за мои услуги поднята");
                } else {
                    System.out.println(doctor + ": цена за мои услуги уменьшена");
                }
                this.price = price;
            }

            public String getStreet() {
                return street;
            }

            public ProceedsAndEstimate getAllProceed() {
                return allProceed;
            }
        };

        Dunno dunno = new Dunno("Незнайка", "лунный город " + davilon, "скафандр");
        Product honeyCake = new Product("коврижка", dawn, 25);

        Magazine allMagazines = new Magazine("Космические гости",
                "В лунный город Давилон прибыл космический путешественник");
        allMagazines.read();

        Photography p1 = new Photography("Незнайка вылезает из автомашины");
        Photography p2 = new Photography("Незнайка вылез из автомашины!");
        Photography p3 = new Photography("Незнайка прибыл в гостиницу");
        Photography p4 = new Photography("Незнайка кушает коврижку");

        VisiblePlaces allPlaces = new VisiblePlaces();
        allPlaces.printing(p1);
        allPlaces.printing(p2);
        allPlaces.printing(p3);
        allPlaces.printing(p4);
        Photography.AdvertisingPhoto addHoneyCake = p4.new AdvertisingPhoto(dunno, honeyCake);
        allPlaces.printing(addHoneyCake);
        allPlaces.read();

        Store Apple = new Store("магазин Apple");
        Store Amazon = new Store("магазин Amazon");
        AllShops.getAllShops();

        {
            AllShops.addProductAllShops(honeyCake);
            int countHoneyCake = 1; // сколько купил каждый человек
            for (int j = 0; j < Human.AllPeoplesInCity.getPopulation(); j++) {
                AllShops.buyProduct(Human.AllPeoplesInCity.allPeoples[j], honeyCake, countHoneyCake);
            }
            if (honeyCake.allProceed.PROCEEDS[DayMonth.month][DayMonth.day] > 1500d) {
                System.out.println(honeyCake.getFactory().getOwner() +
                        " заработал большие деньги за этот день(больше 1500 гривен)");
            }
            if (honeyCake.allProceed.getCount(DayMonth.month, DayMonth.month) > 100) {
                System.out.println("Местные жители едят только коврижки, местным " +
                        "магазинам имеет смысл продавать только их");
            }
            AllShops.removeProduct(new Product());
        }
        {
            int countOfMonth = 0;
            for (int i = 1; i <= 29; i++) {
                countOfMonth += honeyCake.allProceed.getCount(DayMonth.month - 1, i);
            }
            if (honeyCake.allProceed.getCount(DayMonth.month, DayMonth.day) > countOfMonth) {
                System.out.println("За день было продано коврижек столько, " +
                        "сколько не было продано за весь прошлый месяц");
            }
        }
        {
            Photography p5 = new Photography("Адрес доктора " + DrSyringe.getStreet());
            Photography.AdvertisingPhoto addDrSyringe = p5.new AdvertisingPhoto(dunno, DrSyringe.getPerson());
            allMagazines = new Magazine();
            allMagazines.printing(p5);
            allMagazines.printing(addDrSyringe);
            allMagazines.read();
            DrSyringe.setPrice(200.0);
            for (int j = 0; j < Human.AllPeoplesInCity.getPopulation(); j++) {
                DrSyringe.treatment(Human.AllPeoplesInCity.allPeoples[j]);
            }
            if (DrSyringe.getAllProceed().getCount(DayMonth.month, DayMonth.day) > 70) {
                System.out.println("Денежки потекли рекой к доктору Шприцу(за день принято много посетителей)");
            }
        }

    }
}