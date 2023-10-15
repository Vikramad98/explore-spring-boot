package com.vikram.explorespringboot.entity;

import com.vikram.explorespringboot.entity.Gender;
import com.vikram.explorespringboot.entity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PersonTest {

    @InjectMocks
    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person();
    }

    @Test
    void testId() {
        int id = 1;
        person.setId(id);
        assertEquals(id, person.getId());
    }

    @Test
    void testName() {
        String name = "John Doe";
        person.setName(name);
        assertEquals(name, person.getName());
    }

    @Test
    void testGender() {
        Gender gender = Gender.MALE;
        person.setGender(gender);
        assertEquals(gender, person.getGender());
    }

    @Test
    void testAge() {
        int age = 30;
        person.setAge(age);
        assertEquals(age, person.getAge());
    }

    @Test
    void testEmail() {
        String email = "john@example.com";
        person.setEmail(email);
        assertEquals(email, person.getEmail());
    }

    @Test
    void testMobile() {
        String mobile = "1234567890";
        person.setMobile(mobile);
        assertEquals(mobile, person.getMobile());
    }

    @Test
    void testAddress() {
        String address = "123 Main St";
        person.setAddress(address);
        assertEquals(address, person.getAddress());
    }
}
