package personsandpeoples;

import cities.City;

public class Aboriginal extends Person {
    public Aboriginal(City city){
        super("жители Давилона", city.getName(), "наряд жителей Давилона");
        super.addMoney(1000);
    }

}
