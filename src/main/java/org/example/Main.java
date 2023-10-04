package org.example;

import org.example.persistents.Person;
import org.example.persistents.Student;
import org.example.persistents.Teacher;
import org.example.persistents.enumurations.TeacherLevel;
import org.example.service.PersonService;
import org.example.service.StudentService;
import org.example.service.TeacherService;
import org.example.service.impl.PersonServiceImpl;
import org.example.service.impl.StudentServiceImpl;
import org.example.service.impl.TeacherServiceImpl;
import org.example.util.LoggingUtil;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {

        LoggingUtil.initLogManager();

        PersonService personService = new PersonServiceImpl();
        TeacherService teacherService = new TeacherServiceImpl();
        StudentService studentService = new StudentServiceImpl();

//        System.out.println(personService.findAll());
//
        Person amin = new Person("Aminxdfggdbhsfdsgsdfgnn","Bazgidffdjrrr", LocalDate.of(1991,1,1));
        personService.save(amin);
//        System.out.println("--------");
//        Person returnedPerson = personService.signUp();
//        System.out.println(returnedPerson);
//
//        System.out.println("--------");
//        System.out.println(personService.findById(15L));
//
//
//        System.out.println("--------");
//        System.out.println(personService.contain(amin));
//
//        System.out.println("--------");
//        personService.update(amin);
//
//        System.out.println("--------");
//        personService.delete(amin);

//        teacherService.save(new Techer("farzad","afshar",LocalDate.of(1900,1,1),"master",1000, TeacherLevel.LEVEL3));
//        System.out.println(teacherService.findById(18L));
//        System.out.println(teacherService.findAll());

//        teacherService.update(new Teacher(18L,"farzaddd","afshar",LocalDate.of(1990,2,2),0L,"master",2000,TeacherLevel.LEVEL2));


//        Teacher farzad = new Teacher(18L,"farzaddd","afshaaasr",LocalDate.of(1990,2,2),0L,"master",2000,TeacherLevel.LEVEL2);
//
//        System.out.println(teacherService.contain(farzad));


//        studentService.save(new Student("Navid","Nikfar",LocalDate.of(1900,1,1),"Computer", 2020));
//        studentService.save(new Student("Navaaid","Nikaaafar",LocalDate.of(1900,1,1),"Compaaauter", 2020));
//        System.out.println(studentService.findAll());
//        System.out.println(studentService.findById(19));
//        studentService.update(new Student(19L,"Navaaid", "Nikaaafar", LocalDate.of(1900, 1, 1), 1,"Comp------uter", 2020));

    }
}