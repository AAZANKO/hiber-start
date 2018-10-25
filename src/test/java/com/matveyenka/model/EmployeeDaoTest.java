package com.matveyenka.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;

public class EmployeeDaoTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();


    @AfterClass
    public static void closeFactory() {
        FACTORY.close();
    }

    @Before
    public void clean(){
        Session session = FACTORY.openSession();
        session.beginTransaction();
        int result = session.createQuery("delete from Employee").executeUpdate();
        System.out.println(result);
        session.getTransaction().commit();
    }

    @Test
    public void checkSaveEntity() {
        // Configuration() - hibernate.org
        try (Session session = FACTORY.openSession()) {
            // Employee employee = new Employee("ivan2", "2ivan", Gender.FEMALE); // ошибка при использовании OF
            Employee employee = new Employee();
            Serializable save = session.save(employee);
            assertNotNull(save);
            // session.close(); // саве падоет - сессия не закрывается, коннектион остается висеть в памяти
            // не останется соединения которое можно взять с пула
        }
    }

}
