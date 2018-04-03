package com.company.services;

import com.company.models.Person;

import java.util.List;

public interface PersonService {
    void addPerson(Person person);
    void updatePerson(Person person);
    List<Person> getPersons();
    Person getPersonById(int id);
    void deletePerson(int id);
}
