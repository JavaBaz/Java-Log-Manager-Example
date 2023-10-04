package org.example.persistents;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("student")
public class Student extends Person{

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "major")
    private String major;

    @Column(name = "entrance_year")
    private int entranceYear;


    public Student() {
    }

    public Student(long id, String firstName, String lastName, LocalDate dateOfBirth, int studentId, String major, int entranceYear) {
        super(id, firstName, lastName, dateOfBirth);
        this.studentId = studentId;
        this.major = major;
        this.entranceYear = entranceYear;
    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth, int studentId, String major, int entranceYear) {
        super(firstName, lastName, dateOfBirth);
        this.studentId = studentId;
        this.major = major;
        this.entranceYear = entranceYear;
    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String major, int entranceYear) {
        super(firstName, lastName, dateOfBirth);
        this.major = major;
        this.entranceYear = entranceYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", firstName=" + getFirstName() +
                ", lastName=" + getLastName() +
                ", dateOfBirth=" + getDateOfBirth() +
                "studentId=" + studentId +
                ", major='" + major + '\'' +
                ", entranceYear=" + entranceYear +
                '}';
    }
}
