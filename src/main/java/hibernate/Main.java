package hibernate;

import hibernate.model.Director;
import hibernate.model.FilmwebRating;
import hibernate.model.Movie;
import hibernate.repository.DirectorRepository;
import hibernate.repository.FilmwebRatingRepository;
import hibernate.repository.MovieRepository;
import org.hibernate.Session;



public class Main {


    public static void main(String[] args) {

//hibernateFactory.getSessionFactoryHollywoodProg().openSession().close();


//        Session session = hibernateFactory.getSessionFactoryHollywoodProg().openSession();
//        session.close();
//        to będzie w movierepository nie w mainie
//
//        Movie movie = new Movie();
//        movie.setTitle("Jigsaw");
//        movie.setGenre("Horror");
//        movie.setYearOfRelease(2000);
//        ===Add movie===
//        Movie savedMovied = movieRepository.add(movie);
//        System.out.println(savedMovied.getId());
//        System.out.println(movie.getTitle());

//
//        Movie movie2 = new Movie();
//        movie2.setTitle("Thor");
//        movie2.setGenre("Fantasy");
//        movie2.setYearOfRelease(2022);
//        ===Add movie2===
//        movieRepository.add(movie2);
//        System.out.println(movie2.getTitle());

        //===finById===
//        Movie fetchedMovie = movieRepository.findById(2);
//        if(fetchedMovie != null){
//            System.out.println(fetchedMovie.getTitle());
//        }

        //===getAllByGenre===
        //List<Movie> movieList = movieRepository.getAllByGenre("Fantasy");
        //System.out.println(movieList.size());
        //movieList.forEach(m-> System.out.println(m.toString()));
        //movieList.forEach(System.out::println);
//
//        Movie newMovie = new Movie();
//        newMovie.setTitle("Jigsaw 2");
//        newMovie.setGenre("Thriller");
//        newMovie.setYearOfRelease(2022);
//
//        movieRepository.update(1,newMovie);

        MovieRepository movieRepository = new MovieRepository();
        FilmwebRatingRepository filmwebRatingRepository = new FilmwebRatingRepository();

//        Movie movie = new Movie();
//        movie.setTitle("Test 1");
//        movie.setGenre("Fantasy");
//        movie.setYearOfRelease(2000);
//
//        FilmwebRating filmwebRating = new FilmwebRating();
//        filmwebRating.setMaxRating(5.0);
//        filmwebRating.setMinRating(1.0);
//        filmwebRating.setOverallRating(4.6);
//        filmwebRating.setUserQuantity(1000);
//
//        filmwebRating.setMovie(movie);
//        movie.setFilmwebRating(filmwebRating);
//
//        //filmwebRatingRepository.add(filmwebRating);
//        movieRepository.add(movie);

//            Movie movieDb = movieRepository.findById(11);
//            System.out.println(movieDb);
//
//            FilmwebRating filmwebRatingDB = filmwebRatingRepository.findById(2);
//            System.out.println(filmwebRatingDB);

//            movieRepository.delete(12);

//        Director director = new Director();
//        director.setFirstName("Quentin");
//        director.setLastName("Tarantino");
//        director.setNick("Tarantula");

        Movie newMovie = new Movie();
        newMovie.setTitle("Kill Bill 2");
        newMovie.setGenre("Drama");
        newMovie.setYearOfRelease(2000);


        movieRepository.update(1,newMovie );

        DirectorRepository directorRepository = new DirectorRepository();
        Director directorDb = directorRepository.findById(1);
        directorDb.getMovies().forEach(m -> System.out.println(m));

        newMovie.setDirector(directorDb);
        movieRepository.update(2,newMovie);

        Movie movieDb2 = movieRepository.findById(2);
        System.out.println(movieDb2);



    }
}