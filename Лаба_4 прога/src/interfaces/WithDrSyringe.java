package interfaces;

import objects.ProceedsAndEstimate;
import personsandpeoples.Person;

import java.util.stream.Stream;

public interface WithDrSyringe {
    void treatment(Person person);
    Person getPerson();
    void setPrice(double price);
    public ProceedsAndEstimate getAllProceed();
    public String getStreet();
}
