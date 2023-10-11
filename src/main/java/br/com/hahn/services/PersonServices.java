package br.com.hahn.services;

import br.com.hahn.models.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        logger.info("Finding one person!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Guilherme");
        person.setLastName("Hahn");
        person.setAddres("Criciúma - SC");
        person.setGender("Male");
        return person;
    }

    public List<Person> findAll(){
        logger.info("Finding one person!");
        List<Person> persons = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name: " + i);
        person.setLastName("Person Last name: " + i);
        person.setAddres("Person Addres: " + i);
        person.setGender("Male");
        return person;
    }


}
