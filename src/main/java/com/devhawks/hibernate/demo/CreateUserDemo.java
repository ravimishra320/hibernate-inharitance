package com.devhawks.hibernate.demo;

import com.devhawks.entity.Instructor;
import com.devhawks.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateUserDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try

        {
            Student tempStudent = new Student("Ravi", "Mishra", "ravimishra.im@gmail.com", "Hibernate");
            Instructor tempInstructor = new Instructor("Priya", "Sinha", "priyasinha.im@gmail.com", 20000.00);

            session.beginTransaction();

            System.out.println("Saving Student and Instructor");

            session.persist(tempStudent);
            session.persist(tempInstructor);
            session.getTransaction().commit();
            System.out.println("Done !!");
        }finally {
            session.close();
            factory.close();
        }
    }

}
