package builds;

import interfaces.WithService;
import objects.Service;
import personsandpeoples.Person;

public class ServiceCenter extends Institution implements WithService {

    public ServiceCenter(String name) {
        super(name);
    }


    @Override
    public void addService(Service service) {

    }

    @Override
    public void removeService(Service service) {

    }

    @Override
    public void buyService(Person person, Service service) {

    }
}
