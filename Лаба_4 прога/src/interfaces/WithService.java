package interfaces;

import objects.Service;
import personsandpeoples.Person;

public interface WithService {
    public void addService(Service service);
    public void removeService(Service service);
    public void buyService(Person person, Service service);
}
