package cities;

public class Davilon extends City{
    public Davilon(){
        super.setName("Давилон");
        System.out.println("Создан город с названием " + getName());
    }

    public String getName(){
        return super.getName();
    }
}
