package org.example.repository.impl;

import org.example.config.AppEntityManagerFactory;
import org.example.persistents.Person;
import org.example.persistents.Teacher;
import org.example.repository.TeacherRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class TeacherRepositoryImpl implements TeacherRepository {

    private final EntityManagerFactory entityManagerFactory = AppEntityManagerFactory.getEntityManagerFactory();
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();


    @Override
    public Teacher save(Teacher teacher) {
        entityManager.getTransaction().begin();
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();
        entityManager.refresh(teacher);
        return teacher;
    }

    @Override
    public Teacher findById(long id) {
        return entityManager.find(Teacher.class, id);
    }

    @Override
    public List<Teacher> findAll() {
        return entityManager.createQuery("FROM Teacher", Teacher.class).getResultList();
    }

    @Override
    public void update(Teacher teacher) {
        entityManager.getTransaction().begin();
        entityManager.merge(teacher);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Teacher teacher) {
        entityManager.getTransaction().begin();
        Person toDeletePerson ;
        toDeletePerson = entityManager.find(Teacher.class, teacher.getId());
        entityManager.remove(toDeletePerson);
        entityManager.getTransaction().commit();
    }

    @Override
    public boolean contain(Teacher teacher) {
        try {
            Person foundPerson = entityManager.find(Teacher.class, teacher.getId());
            return foundPerson != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
