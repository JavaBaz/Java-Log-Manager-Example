package org.example.service.impl;

import org.example.persistents.Teacher;
import org.example.repository.TeacherRepository;
import org.example.repository.impl.TeacherRepositoryImpl;
import org.example.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    TeacherRepository repository = new TeacherRepositoryImpl();

    @Override
    public Teacher save(Teacher teacher) {
        repository.save(teacher);
        return teacher;
    }

    @Override
    public Teacher findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Teacher> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(Teacher teacher) {
        repository.update(teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        try {
            repository.delete(teacher);
        } catch (IllegalArgumentException e) {
            System.out.println("---> WARNING! : There is no techer like this in the database.");
        }
    }

    @Override
    public boolean contain(Teacher teacher) {
        return repository.contain(teacher);
    }

}
