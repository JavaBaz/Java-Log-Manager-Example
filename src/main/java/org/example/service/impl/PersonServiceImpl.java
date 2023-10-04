package org.example.service.impl;

import org.example.persistents.Person;
import org.example.repository.PersonRepository;
import org.example.repository.impl.PersonRepositoryImpl;
import org.example.service.PersonService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class PersonServiceImpl implements PersonService {

    PersonRepository repository = new PersonRepositoryImpl();

    @Override
    public Person save(Person person) {
        repository.save(person);
        return person;
    }

    @Override
    public Person findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(Person person) {
        repository.update(person);
    }

    @Override
    public void delete(Person person) {
        try {
            repository.delete(person);
        } catch (IllegalArgumentException e) {
            System.out.println("---> WARNING! : There is no Person like this in the database.");
        }
    }

    @Override
    public boolean contain(Person person) {
        return repository.contain(person);
    }

    @Override
    public Person signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pleasn Enter the first name : ");
        String firstName = scanner.next().trim();

        System.out.print("Pleasn Enter the last name : ");
        String lastName = scanner.next().trim();

        System.out.print("Pleasn Enter the year of birth date : ");
        int year = scanner.nextInt();


        System.out.print("Pleasn Enter the month of birth date : ");
        int month = scanner.nextInt();

        System.out.print("Pleasn Enter the day of birth date : ");
        int day = scanner.nextInt();

        LocalDate birthDate = LocalDate.of(year, month, day);

        Person toBeSavedPerson = new Person(firstName,lastName, birthDate);

        save(toBeSavedPerson);

        return toBeSavedPerson;
    }


}
