package personsandpeoples;

import cities.City;

public class AllPersons extends Person {
    public AllPersons(City city){
        super("жители Давилона", city.getName(), "наряд жителей Давилона");
        super.addMoney(1000);
    }

}
