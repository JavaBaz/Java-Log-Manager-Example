package org.example.service.impl;

import org.example.persistents.Student;
import org.example.repository.StudentRepository;
import org.example.repository.impl.StudentRepositoryImpl;
import org.example.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    StudentRepository repository = new StudentRepositoryImpl();

    @Override
    public Student save(Student student) {
        repository.save(student);
        return student;
    }

    @Override
    public Student findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();    }

    @Override
    public void update(Student student) {
        repository.update(student);
    }

    @Override
    public void delete(Student student) {
        try {
            repository.delete(student);
        } catch (IllegalArgumentException e) {
            System.out.println("---> WARNING! : There is no student like this in the database.");
        }
    }

    @Override
    public boolean contain(Student student) {
        return repository.contain(student);    }
}
