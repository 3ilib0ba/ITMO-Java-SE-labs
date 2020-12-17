package cities;

public abstract class City {
    private String name;

    protected void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public String toString(){ return this.name; }
}
