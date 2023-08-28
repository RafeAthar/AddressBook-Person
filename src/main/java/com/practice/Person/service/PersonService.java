package com.practice.Person.service;

import com.practice.Person.entity.Person;
import com.practice.Person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    // READ
    public List<Person> getPersons(){
        return personRepository.findAll();
    }
    public Person getPersonById(int id){
        return personRepository.getById(id);
    }
//    public Person getPersonByFirstName(String firstName){
//        return personRepository.
//    }

    public Person updatePerson(Person person){
        Person existingPerson = personRepository.findById(person.getId()).orElse(null);
        existingPerson.setFirstName(person.getFirstName());
        existingPerson.setLastName(person.getLastName());
        return personRepository.save(person);
    }

    // DELETE
    public String deletePersonById(int id){
        Person existingPerson = personRepository.findById(id).orElse(null);
        if(existingPerson !=null){
            personRepository.deleteById(existingPerson.getId());
            return "The Person has been deleted with id: " + id;
        }
        return "person does not exist already";
    }
    public String deleteAllPersons(){
        personRepository.deleteAll();
        return "Deleted all persons";
    }

    // CREATE
    public Person createPerson(Person person){
        return personRepository.save(person);
    }
    public List<Person> createPersons(List<Person> persons){
        return personRepository.saveAll(persons);
    }


}
