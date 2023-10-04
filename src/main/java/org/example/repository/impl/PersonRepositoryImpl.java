package org.example.repository.impl;


import org.example.config.AppEntityManagerFactory;
import org.example.persistents.Person;
import org.example.repository.PersonRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class PersonRepositoryImpl implements PersonRepository {

    private final EntityManagerFactory entityManagerFactory = AppEntityManagerFactory.getEntityManagerFactory();
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();


    @Override
    public Person save(Person person) {
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.refresh(person);
        return person;
    }

    @Override
    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }


    @Override
    public List<Person> findAll() {
        return entityManager.createQuery("FROM Person", Person.class).getResultList();
    }

    @Override
    public void update(Person person) {
        entityManager.getTransaction().begin();
        entityManager.merge(person);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Person person) {
        entityManager.getTransaction().begin();
        Person toDeletePerson ;
        toDeletePerson = entityManager.find(Person.class, person.getId());
        entityManager.remove(toDeletePerson);
        entityManager.getTransaction().commit();
    }

    @Override
    public boolean contain(Person person) {
        try {
            Person foundPerson = entityManager.find(Person.class, person.getId());
            return foundPerson != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
