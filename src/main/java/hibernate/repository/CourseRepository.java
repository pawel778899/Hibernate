package hibernate.repository;

import hibernate.HibernateFactory;
import hibernate.model.Course;
import hibernate.model.FilmwebRating;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CourseRepository {

        private HibernateFactory hibernateFactory = new HibernateFactory();

        public Course add(Course course) {
            Session session = hibernateFactory.getSessionFactoryUniversityProg().openSession();
            Transaction transaction = session.beginTransaction();

            try {
                session.save(course);
                transaction.commit();
                return course;

            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            } finally {
                session.close();
            }

            return null;
        }

        public Course findById(int id) {
            try (Session session = hibernateFactory.getSessionFactoryUniversityProg().openSession()) {
                return session.get(Course.class, id);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }
