package personsandpeoples;

public abstract class Person{
    private String name;
    private String place = "Нигде";
    private String wear;
    protected double money = 0;

    Person(){
        name = "житель Давилона";
        setPlace();
        setWear();
    }
    Person(String name, String place, String wear){
        this.name = name;
        setPlace(place);
        setWear(wear);
    }

    protected void setName(String name){ this.name = name; }
    public String getName(){ return this.name; }
    public void setPlace(){ place = "город Давилон"; }
    public void setPlace(String place){ this.place = place; }
    public String getPlace(){ return place; }
    public void setWear(){ this.wear = "наряд жителя Давилона"; }
    public void setWear(String wear){ this.wear = wear; }
    public String getWear(){ return wear; }

    public void addMoney(double money){ this.money += money; }
    public void getMoney(){ System.out.println(money);}

    public String toString(){
        return this.name;
    }
}
