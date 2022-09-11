package hibernate.repository;

import hibernate.HibernateFactory;
import hibernate.model.FilmwebRating;
import hibernate.model.Movie;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FilmwebRatingRepository {

    private HibernateFactory hibernateFactory = new HibernateFactory();

    public FilmwebRating add(FilmwebRating filmwebRating) {
        Session session = hibernateFactory.getSessionFactoryHollywoodProg().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(filmwebRating);
            transaction.commit();
            return filmwebRating;

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

        return null;
    }

    public FilmwebRating findById(int id) {
        try (Session session = hibernateFactory.getSessionFactoryHollywoodProg().openSession()) {
            return session.get(FilmwebRating.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}


