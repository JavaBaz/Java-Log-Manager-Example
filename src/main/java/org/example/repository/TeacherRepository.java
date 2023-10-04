package org.example.repository;

import org.example.persistents.Teacher;

import java.util.List;

public interface TeacherRepository {
    Teacher save(Teacher teacher);
    Teacher findById(long id);
    List<Teacher> findAll();
    void update(Teacher teacher);
    void delete(Teacher teacher);
    boolean contain(Teacher teacher);
}
