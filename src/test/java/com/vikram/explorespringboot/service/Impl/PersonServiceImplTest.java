package com.vikram.explorespringboot.service.Impl;

import com.vikram.explorespringboot.entity.Gender;
import com.vikram.explorespringboot.entity.Person;
import com.vikram.explorespringboot.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceImplTest {

    @InjectMocks
    private PersonServiceImpl personService;

    @Mock
    private PersonRepository personRepository;

    private List<Person> testPersons;

    @BeforeEach
    void setUp() {
        testPersons = Arrays.asList(
                new Person(1, "Alice", Gender.FEMALE, 25, "alice@example.com", "9876543210", "456 Elm St"),
                new Person(2, "Bob", Gender.MALE, 30, "bob@example.com", "5555555555", "789 Oak St")
        );
    }

    @Test
    void testGetPersonById() {
        int personId = 1;
        Person testPerson = testPersons.get(0);
        when(personRepository.findById(personId)).thenReturn(Optional.of(testPerson));

        Optional<Person> result = personService.getPersonById(personId);

        assertEquals(testPerson, result.orElse(null));
    }

    @Test
    void testCreatePerson() {
        Person newPerson = new Person(3, "Charlie", Gender.MALE, 28, "charlie@example.com", "3333333333", "987 Pine St");
        when(personRepository.save(newPerson)).thenReturn(newPerson);

        Person result = personService.createPerson(newPerson);

        assertEquals(newPerson, result);
    }

    @Test
    void testGetPersonList() {
        when(personRepository.findAll()).thenReturn(testPersons);

        List<Person> result = personService.getPersonList();

        assertEquals(testPersons, result);
    }

    @Test
    void testGetPersonByAge() {
        int age = 25;
        List<Person> expectedPersons = Collections.singletonList(testPersons.get(0));

        when(personRepository.findPersonsByAge(age)).thenReturn(expectedPersons);

        List<Person> result = personService.getPersonByAge(age);

        assertEquals(expectedPersons, result);
    }

    @Test
    void testGetPersonByGender() {
        Gender gender = Gender.FEMALE;
        List<Person> expectedPersons = Collections.singletonList(testPersons.get(0));

        when(personRepository.findPersonsByGender(gender)).thenReturn(expectedPersons);

        List<Person> result = personService.getPersonByGender(gender);

        assertEquals(expectedPersons, result);
    }
}
