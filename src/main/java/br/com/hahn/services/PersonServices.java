package br.com.hahn.services;

import br.com.hahn.exceptions.ResourceNotFoundException;
import br.com.hahn.models.Person;
import br.com.hahn.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public Person findById(Long id){
        logger.info("Finding one person!");
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Person create(Person person){
        logger.info("Creating one Person!");
        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Update one Person!");

        var entity = repository.findById(person.getId()).orElseThrow(() -> new RuntimeException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddres(person.getAddres());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id){
        logger.info("delete one Person!");

        var entity = repository.findById(id).orElseThrow(() -> new RuntimeException("No records found for this ID"));

        repository.delete(entity);
    }

    public List<Person> findAll(){
        logger.info("Finding one person!");

        return repository.findAll();
    }
}
