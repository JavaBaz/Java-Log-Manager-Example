package org.example.repository;

import org.example.persistents.Person;

import java.util.List;

public interface PersonRepository {

    Person save(Person person);
    Person findById(long id);
    List<Person> findAll();
    void update(Person person);
    void delete(Person person);
    boolean contain(Person person);
}
