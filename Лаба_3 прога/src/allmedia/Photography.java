package allmedia;

import personsandpeoples.Person;

public class Photography{
    private String value = "";

    Photography(){
        this.value = "empty photo";
    }
    public Photography(String content){
        this.value = content;
        //System.out.println("Создано фото на котором:"  + content);
    }

    Photography(Person person) {
        this.value = "на фото изображен " + person +
                ", он находится в месте " + person.getPlace() +
                ", на нем можно видеть " + person.getWear();
    }

    public String toString(){
        return this.value;
    }

    public boolean equals(Photography p1){
        if (this.value.equals(p1.value))
            return true;
        return false;
    }
}
