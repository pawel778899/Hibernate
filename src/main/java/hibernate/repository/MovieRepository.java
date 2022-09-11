package hibernate.repository;

import hibernate.HibernateFactory;
import hibernate.model.Movie;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.Collections;
import java.util.List;

public class MovieRepository {
    private HibernateFactory hibernateFactory = new HibernateFactory();

    public Movie add(Movie movie) {
        Session session = hibernateFactory.getSessionFactoryHollywoodProg().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(movie);
            transaction.commit();
            return movie;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }

        return null;
    }

    public Movie findById(int id) {
        try (Session session = hibernateFactory.getSessionFactoryHollywoodProg().openSession()) {
            return session.get(Movie.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Movie> getAllByGenre(String genre) {
        Session session = hibernateFactory.getSessionFactoryHollywoodProg().openSession();
        NativeQuery query = session.createNativeQuery("SELECT * FROM movies WHERE genre = ?", Movie.class);
        query.setParameter(1, genre);

        try {
            List<Movie> movieList = query.getResultList();
            return movieList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return Collections.emptyList();

    }

    public void update(int id, Movie newMovie) {
        Session session = hibernateFactory.getSessionFactoryHollywoodProg().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Movie movie = session.find(Movie.class, id);

            if (newMovie.getTitle() != null) {
                movie.setTitle(newMovie.getTitle());
            }

            movie.setGenre(newMovie.getGenre());
            movie.setYearOfRelease(newMovie.getYearOfRelease());
            movie.setFilmwebRating(newMovie.getFilmwebRating());
            movie.setDirector(newMovie.getDirector());

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public void delete(int id) {
        Session session = hibernateFactory.getSessionFactoryHollywoodProg().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Movie movie = session.get(Movie.class, id);
            session.delete(movie);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }





}
