package hibernate.repository;

import hibernate.HibernateFactory;
import hibernate.model.Director;
import hibernate.model.Movie;
import org.hibernate.Session;

public class DirectorRepository {

    private HibernateFactory hibernateFactory = new HibernateFactory();


    public Director findById(int id) {
        try (Session session = hibernateFactory.getSessionFactoryHollywoodProg().openSession()) {
            return session.get(Director.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
