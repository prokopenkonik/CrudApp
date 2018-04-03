package com.company.dao;

import com.company.models.Person;

import java.util.List;

public interface PersonDao {
    void addPerson(Person person);
    void updatePerson(Person person);
    List<Person> getPersons();
    Person getPersonById(int id);
    void deletePerson(int id);
}
