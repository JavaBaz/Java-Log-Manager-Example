package org.example.repository.impl;

import org.example.config.AppEntityManagerFactory;
import org.example.persistents.Person;
import org.example.persistents.Student;
import org.example.persistents.Teacher;
import org.example.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentRepositoryImpl implements StudentRepository {

    private final EntityManagerFactory entityManagerFactory = AppEntityManagerFactory.getEntityManagerFactory();
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private static final Logger LOGGER = Logger.getLogger(StudentRepositoryImpl.class.getName());


    @Override
    public Student save(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.refresh(student);
        LOGGER.log(Level.INFO, "Student " + student.getFirstName() + " " + student.getLastName() + " saved to database successfully.");
        return student;
    }

    @Override
    public Student findById(long id) {
        LOGGER.log(Level.INFO, "Student with id : " + id + " searched in database to be found.");
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        LOGGER.log(Level.INFO, "All student searched.");
        return entityManager.createQuery("FROM Student", Student.class).getResultList();
    }

    @Override
    public void update(Student student) {
        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();
        LOGGER.log(Level.INFO, "Student " + student.getFirstName() + " " + student.getLastName() + "with id : " + student.getId() + " updated in database successfully.");
    }

    @Override
    public void delete(Student student) {
        entityManager.getTransaction().begin();
        Person toDeletePerson;
        toDeletePerson = entityManager.find(Student.class, student.getId());
        entityManager.remove(toDeletePerson);
        entityManager.getTransaction().commit();
        LOGGER.log(Level.INFO, "Student " + student.getFirstName() + " " + student.getLastName() + "with id : " + student.getId() + " deleted in database successfully.");
    }

    @Override
    public boolean contain(Student student) {
        try {
            Person foundPerson = entityManager.find(Student.class, student.getId());
            LOGGER.log(Level.INFO, "Student " + student.getFirstName() + " " + student.getLastName() + "with id : " + student.getId() + " found in database successfully.");
            return foundPerson != null;
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.log(Level.WARNING, "Student " + student.getFirstName() + " " + student.getLastName() + "with id : " + student.getId() + " was not in database!");
            return false;
        }
    }
}
