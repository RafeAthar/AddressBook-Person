package com.practice.Person.controller;

import com.practice.Person.entity.Person;
import com.practice.Person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    // READ
    @GetMapping("/getAllPersons")
    public List<Person> getAllPersons(){
        return personService.getPersons();
    }
    @GetMapping("/getPerson/{id}")
    public Person getPerson(@PathVariable int id){
        return personService.getPersonById(id);
    }

    // CREATE
    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }
    @PostMapping("/addPersons")
    public List<Person> addPersons(@RequestBody List<Person> persons){
        return personService.createPersons(persons);
    }

    // DELETE
    @DeleteMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable int id){
        return personService.deletePersonById(id);
    }
    @DeleteMapping("/deleteAllPersons")
    public String deleteAll(){
        return personService.deleteAllPersons();
    }

    // UPDATE
    @PutMapping("/updatePerson")
    public Person updatePerson(@RequestBody Person person){
        return personService.updatePerson(person);
    }

}
