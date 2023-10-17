package com.vikram.repository;

import com.vikram.entity.Gender;
import com.vikram.entity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    Person person1 = new Person(1, "Alice", Gender.FEMALE, 25, "alice@example.com", "9876543210", "456 Elm St");
    Person person2 = new Person(2, "Bob", Gender.MALE, 30, "bob@example.com", "5555555555", "789 Oak St");


    @Deprecated
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void testFindPersonsByAge() {
        personRepository.saveAll(List.of(person1, person2));

        List<Person> result = personRepository.findPersonsByAge(25);

        assertEquals(1, result.size()); // Expecting one person with age 25
    }

    @Test
    void testFindPersonsByGender() {
        personRepository.saveAll(List.of(person1, person2));

        List<Person> result = personRepository.findPersonsByGender(Gender.FEMALE);

        assertEquals(1, result.size()); // Expecting two persons with gender FEMALE
    }
}
