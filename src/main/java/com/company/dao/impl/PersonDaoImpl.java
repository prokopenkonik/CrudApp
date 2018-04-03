package com.company.dao.impl;

import com.company.dao.PersonDao;
import com.company.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    private static final Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(person);
        logger.info("Person saved successfully, " + person);
    }

    @Override
    public void updatePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.update(person);
        logger.info("Person updated successfully, " + person);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Person> getPersons() {
        Session session = sessionFactory.getCurrentSession();
        List<Person> personList = session.createQuery("from Person").list();
        logger.info("Persons loaded successfully: ");
        for (Person p : personList) {
            logger.info(p.toString());
        }
        return personList;
    }

    @Override
    public Person getPersonById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person p = (Person) session.load(Person.class, id);
        logger.info("Person loaded successfully," + p);
        return p;
    }

    @Override
    public void deletePerson(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person p = (Person) session.load(Person.class, id);
        if (p != null) {
            session.delete(p);
        }
        logger.info("Person deleted successfully," + p);
    }
}
