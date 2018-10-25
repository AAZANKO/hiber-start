package com.matveyenka;

import com.matveyenka.model.Employee;
import com.matveyenka.model.Gender;
import lombok.Cleanup;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

/***
 * FATAL -> ERROR -> WARN -> INFO -> DEBUG -> TRACE
 *
 * если DEBUG то все до FATAL -> ERROR -> WARN -> INFO -> DEBUG
 *
 * если INFO то все до FATAL -> ERROR -> WARN -> INFO
 */
public class OrmDemo {

    public static final Logger LOG = Logger.getLogger(OrmDemo.class);

    public static void main(String[] args) {

        try {
            @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            @Cleanup Session session = sessionFactory.openSession();
            session.beginTransaction();
            LOG.debug("Debug message!");
            // Serializable ivan = session.save(Employee.of("testing2", "0000", Gender.MALE));
            session.save(Employee.builder()
                            .name("te22st5")
                            .age("192003")
                            .gender(Gender.FEMALE).build()); // .build() - забыл
            session.getTransaction().commit();
            LOG.info("Log Info Message!!!");
        }catch (Throwable e){
            LOG.error("Save Employee Info!", e);
        }


/*

        Employee sveta = new Employee("Svetik", "qwerty123456", Gender.FEMALE);
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            // открытие транзакции
            session.beginTransaction();

            session.save(sveta);

            System.out.println("-=0=-");
            Employee load = session.load(Employee.class, 1L);
            System.out.println(load.getId()+" "+load.getName()+" "+load.getAge());

            // Hibernate.unproxy(load)


            System.out.println("-=1=-");
            Employee employee = session.get(Employee.class, sveta.getId());
            System.out.println(employee);

            session.evict(employee); // отделение объекта от кэша
            System.out.println("-=2=-");
            Employee employee2 = session.get(Employee.class, sveta.getId());
            System.out.println(employee2);

            session.delete(employee2);
            System.out.println("-=2.1=-");
            System.out.println(employee2);

            session.clear();
            System.out.println("-=2.2=-");
            Employee employee3 = session.get(Employee.class, sveta.getId());
            System.out.println(employee3);

            // закрытие транзакции
            session.getTransaction().commit();

        }
        System.out.println("-=3=-");
        System.out.println(sveta);

*/



        /*--------------------------------------------------------------------------------------------*/

/*        Employee sveta = new Employee("Sveta7", "qwerty123456");
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            // открытие транзакции
            session.beginTransaction();

            Serializable save = session.save(sveta);
            // session.persist(sveta); // тоже что и выше но использовать только с транзакциями

            System.out.println("-=1=-");
            Employee employee = session.get(Employee.class, sveta.getId());
            System.out.println(employee);

            session.evict(employee);
            System.out.println("-=2=-");
            Employee employee2 = session.get(Employee.class, sveta.getId());
            System.out.println(employee2);

            session.clear();
            System.out.println("-=2.2=-");
            Employee employee3 = session.get(Employee.class, sveta.getId());
            System.out.println(employee3);

            // закрытие транзакции
            session.getTransaction().commit();

        }
        System.out.println("-=3=-");
        System.out.println(sveta);*/


        /*--------------------------------------------------------------------------------------------*/


/*        // Configuration() - hibernate.org
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            Employee employee = new Employee("00002", "1210");
            session.save(employee);
            // session.close(); // саве падоет - сессия не закрывается, коннектион остается висеть в памяти
            // не останется соединения которое можно взять с пула
            List<Employee> list = session.createQuery("select e from Employee e", Employee.class).list();
            System.out.println(list.size());
        }*/

    }
}
