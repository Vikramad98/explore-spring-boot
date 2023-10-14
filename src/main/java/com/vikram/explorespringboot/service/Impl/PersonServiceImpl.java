package com.vikram.explorespringboot.service.Impl;

import com.vikram.explorespringboot.entity.Gender;
import com.vikram.explorespringboot.entity.Person;
import com.vikram.explorespringboot.repository.PersonRepository;
import com.vikram.explorespringboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;
    @Override
    public Optional<Person> getPersonById(int id) {
        return personRepository.findById(id);
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    /**
     * @return list of person
     */
    @Override
    public List<Person> getPersonList() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> getPersonByAge(int age) {
        return personRepository.findPersonsByAge(age);
    }

    @Override
    public List<Person> getPersonByGender(Gender gender) {
        return personRepository.findPersonsByGender(gender);
    }
}
