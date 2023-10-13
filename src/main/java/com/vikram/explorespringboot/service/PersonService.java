package com.vikram.explorespringboot.service;

import com.vikram.explorespringboot.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    public Optional<Person> getPersonById(int id);

    Person createPerson(Person person);

    List<Person> getPersonList();
}
