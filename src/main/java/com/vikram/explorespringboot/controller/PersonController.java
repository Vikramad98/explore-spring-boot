package com.vikram.explorespringboot.controller;

import com.vikram.explorespringboot.entity.Person;
import com.vikram.explorespringboot.service.Impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonController {

    @Autowired
    PersonServiceImpl personService;

    @GetMapping("/person/{id}")
    public ResponseEntity<Optional<Person>> getPersonById(@PathVariable int id){
        Optional<Person> person = personService.getPersonById(id);
        return ResponseEntity.ok(person);
    }

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getPersonList(){
        List<Person> persons = personService.getPersonList();
        return ResponseEntity.ok(persons);
    }

    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person newPerson = personService.createPerson(person);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }
}
