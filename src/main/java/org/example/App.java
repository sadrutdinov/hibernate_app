package org.example;

import org.example.model.Passport;
import org.example.model.Person;
import org.example.task.Principal;
import org.example.task.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Principal.class)
                .addAnnotatedClass(School.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Principal principal = session.get(Principal.class, 1);
//            System.out.println(principal);
//
//            School school = principal.getSchool();
//            System.out.println(school);

//            School school = session.get(School.class, 3);
//            System.out.println(school);
//            Principal principal = school.getPrincipal();
//            System.out.println(principal);

//            Principal principal = new Principal("Tanya", 50);
//            School school = new School(64);
//
//            principal.setSchool(school);
//            session.save(principal);

//            Principal newPrincipal = new Principal("NEW", 28);
//            session.save(newPrincipal);
//
//            School school = session.get(School.class, 5);
//            school.setPrincipal(newPrincipal);

            Principal principal = session.get(Principal.class, 3);
            School school = session.get(School.class, 2);

            System.out.println("Пытаемся добавить Katy новую школу");
            // ОШИБКА: повторяющееся значение ключа нарушает ограничение уникальности "school_principal_id_key"
            //  Подробности: Ключ "(principal_id)=(3)" уже существует.
            school.setPrincipal(principal);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
