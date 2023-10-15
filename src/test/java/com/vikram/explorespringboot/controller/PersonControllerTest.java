package com.vikram.explorespringboot.controller;

import com.vikram.explorespringboot.entity.Gender;
import com.vikram.explorespringboot.entity.Person;
import com.vikram.explorespringboot.service.Impl.PersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersonControllerTest {

    @InjectMocks
    private PersonController personController;

    @Mock
    private PersonServiceImpl personService;

    @Deprecated
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetPersonById() {
        int personId = 1;
        Person person = new Person(personId, "John Doe", Gender.MALE, 30, "john@example.com", "1234567890", "123 Main St");

        when(personService.getPersonById(personId)).thenReturn(Optional.of(person));

        ResponseEntity<Optional<Person>> response = personController.getPersonById(personId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(person, Objects.requireNonNull(response.getBody()).orElse(null));
    }

    @Test
    void testGetPersonByAge() {
        int age = 25;
        List<Person> persons = Arrays.asList(
                new Person(1, "Alice", Gender.FEMALE, age, "alice@example.com", "9876543210", "456 Elm St"),
                new Person(2, "Bob", Gender.MALE, age, "bob@example.com", "5555555555", "789 Oak St")
        );

        when(personService.getPersonByAge(age)).thenReturn(persons);

        ResponseEntity<List<Person>> response = personController.getPersonByAge(age);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(persons, response.getBody());
    }

    @Test
    void testGetPersonByGender() {
        Gender gender = Gender.FEMALE;
        List<Person> persons = Arrays.asList(
                new Person(1, "Alice", gender, 25, "alice@example.com", "9876543210", "456 Elm St"),
                new Person(2, "Eve", gender, 30, "eve@example.com", "1111111111", "123 Cherry St")
        );

        when(personService.getPersonByGender(gender)).thenReturn(persons);

        ResponseEntity<List<Person>> response = personController.getPersonByGender(gender);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(persons, response.getBody());
    }

    @Test
    void testGetPersonList() {
        List<Person> persons = Arrays.asList(
                new Person(1, "Alice", Gender.FEMALE, 25, "alice@example.com", "9876543210", "456 Elm St"),
                new Person(2, "Bob", Gender.MALE, 30, "bob@example.com", "5555555555", "789 Oak St")
        );

        when(personService.getPersonList()).thenReturn(persons);

        ResponseEntity<List<Person>> response = personController.getPersonList();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(persons, response.getBody());
    }

    @Test
    void testCreatePerson() {
        Person newPerson = new Person(3, "Charlie", Gender.MALE, 28, "charlie@example.com", "3333333333", "987 Pine St");

        when(personService.createPerson(any(Person.class))).thenReturn(newPerson);

        ResponseEntity<Person> response = personController.createPerson(newPerson);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newPerson, response.getBody());
    }
}
