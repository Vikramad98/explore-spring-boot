package com.vikram.explorespringboot.repository;

import com.vikram.explorespringboot.entity.Gender;
import com.vikram.explorespringboot.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {


    List<Person> findPersonsByAge(int age);

    List<Person> findPersonsByGender(Gender gender);
}
