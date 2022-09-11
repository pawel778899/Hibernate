package hibernate.repository;

import hibernate.HibernateFactory;
import hibernate.model.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TeacherRepository {
    HibernateFactory hibernateFactory = new HibernateFactory();

    public Teacher add(Teacher teacher) {
        Session session = hibernateFactory.getSessionFactoryUniversityProg().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(teacher);
            transaction.commit();;
            return teacher;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

        return null;
    }


    public Teacher findById(int id) {
        try (Session session = hibernateFactory.getSessionFactoryUniversityProg().openSession()) {
            return session.get(Teacher.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
