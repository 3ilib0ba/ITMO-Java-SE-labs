package personsandpeoples;

public class Human extends Person {
    public Human() {
        super();
        super.addMoney(1000);
        addHuman(this);
    }
    public Human(String name) {
        super(name);
        super.addMoney(1000);
    }

    private static int population = 100;
    public static void setPopulation(int newPopulation){
        population = newPopulation;
    }
    public static int getPopulation(){
        return population;
    }
    public static Human[] allPeoples = new Human[population];
    public static void addHuman(Human human){
        for (int i = 0; i < population; i++){
            if (allPeoples[i] != null) {
            } else {
                allPeoples[i] = human;
                return;
            }
        }
        System.out.println("Невозможно создать объект, в городе не может быть столько людей");
    }

}

