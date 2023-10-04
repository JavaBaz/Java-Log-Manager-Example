package org.example.service;

import org.example.persistents.Student;

import java.util.List;

public interface StudentService {
    Student save(Student student);
    Student findById(long id);
    List<Student> findAll();
    void update(Student student);
    void delete(Student student);
    boolean contain(Student student);
}
