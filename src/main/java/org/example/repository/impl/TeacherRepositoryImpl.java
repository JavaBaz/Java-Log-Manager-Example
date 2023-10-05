package org.example.repository.impl;

import org.example.config.AppEntityManagerFactory;
import org.example.persistents.Person;
import org.example.persistents.Teacher;
import org.example.repository.TeacherRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeacherRepositoryImpl implements TeacherRepository {

    private final EntityManagerFactory entityManagerFactory = AppEntityManagerFactory.getEntityManagerFactory();
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private static final Logger LOGGER = Logger.getLogger(TeacherRepositoryImpl.class.getName());


    @Override
    public Teacher save(Teacher teacher) {
        entityManager.getTransaction().begin();
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();
        entityManager.refresh(teacher);
        LOGGER.log(Level.INFO, "Teacher " + teacher.getFirstName() + " " + teacher.getLastName() + " saved to database successfully.");
        return teacher;
    }

    @Override
    public Teacher findById(long id) {
        LOGGER.log(Level.INFO, "Teacher with id : " + id + " searched in database to be found.");
        return entityManager.find(Teacher.class, id);
    }

    @Override
    public List<Teacher> findAll() {
        LOGGER.log(Level.INFO, "All teacher searched.");
        return entityManager.createQuery("FROM Teacher", Teacher.class).getResultList();
    }

    @Override
    public void update(Teacher teacher) {
        entityManager.getTransaction().begin();
        entityManager.merge(teacher);
        entityManager.getTransaction().commit();
        LOGGER.log(Level.INFO, "Teacher " + teacher.getFirstName() + " " + teacher.getLastName() + "with id : " + teacher.getId() + " updated in database successfully.");
    }

    @Override
    public void delete(Teacher teacher) {
        entityManager.getTransaction().begin();
        Person toDeletePerson;
        toDeletePerson = entityManager.find(Teacher.class, teacher.getId());
        entityManager.remove(toDeletePerson);
        entityManager.getTransaction().commit();
        LOGGER.log(Level.INFO, "Teacher " + teacher.getFirstName() + " " + teacher.getLastName() + "with id : " + teacher.getId() + " deleted in database successfully.");
    }

    @Override
    public boolean contain(Teacher teacher) {
        try {
            Person foundPerson = entityManager.find(Teacher.class, teacher.getId());
            LOGGER.log(Level.INFO, "Teacher " + teacher.getFirstName() + " " + teacher.getLastName() + "with id : " + teacher.getId() + " found in database successfully.");
            return foundPerson != null;
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.log(Level.WARNING, "Teacher " + teacher.getFirstName() + " " + teacher.getLastName() + "with id : " + teacher.getId() + " was not in database!");
            return false;
        }
    }
}
