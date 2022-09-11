package hibernate.model;


import com.mysql.cj.exceptions.DataReadException;

import javax.persistence.*;
import java.util.Set;

@Entity // tabela w bazie danych
@Table(name="movies")
public class Movie {

    @Id // klucz gówny
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoinkrementacja
    @Column(nullable = false) // jak się ma generować klucz gówny
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genre;

    @Column(name ="year_of_release")
    private int yearOfRelease;
    @Column(name ="test")
    private int test;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "filmweb_id",referencedColumnName = "id")
    private FilmwebRating filmwebRating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id")
    private Director director;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "movie_publisher",
            joinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "id", columnDefinition = "INT")},
            inverseJoinColumns = {@JoinColumn(name = "publisher_id",referencedColumnName = "id",columnDefinition = "BIGINT")}
    )
    private Set<Publisher> publishers;

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public FilmwebRating getFilmwebRating() {
        return filmwebRating;
    }

    public void setFilmwebRating(FilmwebRating filmwebRating) {
        this.filmwebRating = filmwebRating;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", test=" + test +
                ", filmwebRating=" + filmwebRating +
                ", director=" + director +
                '}';
    }
}
