package hibernate.repository;

import hibernate.HibernateFactory;
import hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class StudentRepository {

    public Student add(Student student) {
        Session session = hibernateFactory.getSessionFactoryUniversityProg().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(student);
            transaction.commit();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

        return null;
    }
    public Student findByIndexNumber(int indexNumber) {
        try (Session session = hibernateFactory.getSessionFactoryUniversityProg().openSession()) {
            return session.get(Student.class, indexNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    HibernateFactory hibernateFactory = new HibernateFactory();
}
