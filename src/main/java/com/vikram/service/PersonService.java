package com.vikram.service;

import com.vikram.entity.Gender;
import com.vikram.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Optional<Person> getPersonById(int id);

    Person createPerson(Person person);

    List<Person> getPersonList();

    List<Person> getPersonByAge(int age);

    List<Person> getPersonByGender(Gender gender);
}
