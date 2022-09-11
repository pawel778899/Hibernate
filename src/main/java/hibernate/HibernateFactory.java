package hibernate;

import hibernate.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {

    //otwieranie i łączenie z bazą danych
    public SessionFactory getSessionFactory() {

        Configuration mysqlCfg = new Configuration();
        mysqlCfg.configure("hibernate.cfg.xml");

        return mysqlCfg.buildSessionFactory();

// Konfiguracja 1
//        public SessionFactory getSessionFactory() {
//            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//            MetadataSources sources = new MetadataSources(registry);
//            Metadata metadata = sources.getMetadataBuilder().build();
//
//            return metadata.getSessionFactoryBuilder().build();
//        }
    }
    //Konfiguracja programistyczna dla db Hollywood
    public SessionFactory getSessionFactoryHollywoodProg() {
        Configuration config = new Configuration();
        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hollywood?serverTimezone=Europe/Rome");
        config.setProperty("hibernate.connection.username", "root");
        config.setProperty("hibernate.connection.password", "778899");
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        config.setProperty("hibernate.hbm2ddl.auto", "update");
        config.setProperty("hibernate.show_sql", "true");

        config.addAnnotatedClass(Movie.class);
        config.addAnnotatedClass(FilmwebRating.class);
        config.addAnnotatedClass(Director.class);
        config.addAnnotatedClass(Publisher.class);

        return config.buildSessionFactory();

    }
    //Konfiguracja nie programistyczna 2 dla db university - dodany plik hibernate-university.cfg.xml
//    public SessionFactory getUniversitySession() {
//        Configuration configuration = new Configuration();
//        configuration.configure("hibernate-university.cfg.xml");
//    }
//Konfiguracja programistyczna dla db University
    public SessionFactory getSessionFactoryUniversityProg() {
        Configuration config = new Configuration();
        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/university?serverTimezone=Europe/Rome");
        config.setProperty("hibernate.connection.username", "root");
        config.setProperty("hibernate.connection.password", "778899");
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        config.setProperty("hibernate.hbm2ddl.auto", "validate");
        config.setProperty("hibernate.show_sql", "true");

        config.addAnnotatedClass(Teacher.class);
        config.addAnnotatedClass(Student.class);
        config.addAnnotatedClass(Course.class);



        return config.buildSessionFactory();

    }


}

