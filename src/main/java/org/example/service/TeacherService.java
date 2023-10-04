package org.example.service;

import org.example.persistents.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher save(Teacher teacher);
    Teacher findById(long id);
    List<Teacher> findAll();
    void update(Teacher teacher);
    void delete(Teacher teacher);
    boolean contain(Teacher teacher);
}
