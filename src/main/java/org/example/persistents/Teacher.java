package org.example.persistents;


import org.example.persistents.enumurations.TeacherLevel;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("teacher")
public class Teacher extends Person {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id")
    private long teacherId;

    @Column(name = "degree")
    private String degree;


    @Column(name = "salary")
    private int salary;

    @Column(name = "teacher_level")
    private TeacherLevel teacherLevel;

    public Teacher() {
    }

    public Teacher(long id, String firstName, String lastName, LocalDate dateOfBirth, long teacherId, String degree, int salary, TeacherLevel teacherLevel) {
        super(id, firstName, lastName, dateOfBirth);
        this.teacherId = teacherId;
        this.degree = degree;
        this.salary = salary;
        this.teacherLevel = teacherLevel;
    }

    public Teacher(String firstName, String lastName, LocalDate dateOfBirth, String degree, int salary, TeacherLevel teacherLevel) {
        super(firstName, lastName, dateOfBirth);
        this.degree = degree;
        this.salary = salary;
        this.teacherLevel = teacherLevel;
    }

    @Override
    public String toString() {
        return "Techer{" +
                "id=" + getId() +
                ", firstName=" + getFirstName() +
                ", lastName=" + getLastName() +
                ", dateOfBirth=" + getDateOfBirth() +
                ", teacherId=" + teacherId +
                ", degree='" + degree + '\'' +
                ", salary=" + salary +
                ", teacherLevel=" + teacherLevel +
                '}';
    }
}
