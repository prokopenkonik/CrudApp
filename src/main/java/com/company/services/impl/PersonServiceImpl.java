package com.company.services.impl;

import com.company.dao.PersonDao;
import com.company.models.Person;
import com.company.services.PersonService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    @Transactional
    public void addPerson(Person person) {
        personDao.addPerson(person);
    }

    @Override
    @Transactional
    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }

    @Override
    @Transactional
    public List<Person> getPersons() {
        return personDao.getPersons();
    }

    @Override
    @Transactional
    public Person getPersonById(int id) {
        return personDao.getPersonById(id);
    }

    @Override
    @Transactional
    public void deletePerson(int id) {
        personDao.deletePerson(id);
    }
}
