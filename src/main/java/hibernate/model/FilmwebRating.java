package hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "filmweb_rating")
public class FilmwebRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //autoinkrementacja
    private  int id;

    @Column(name = "overall_rating")
    private double overallRating;

    @Column(name = "min_rating")
    private double minRating;

    @Column(name = "max_rating")
    private double maxRating;

    @Column(name = "user_quantity")
    private int userQuantity;

    @OneToOne(mappedBy = "filmwebRating")
    private Movie movie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(double overallRating) {
        this.overallRating = overallRating;
    }

    public double getMinRating() {
        return minRating;
    }

    public void setMinRating(double minRating) {
        this.minRating = minRating;
    }

    public double getMaxRating() {
        return maxRating;
    }

    public void setMaxRating(double maxRating) {
        this.maxRating = maxRating;
    }

    public int getUserQuantity() {
        return userQuantity;
    }

    public void setUserQuantity(int userQuantity) {
        this.userQuantity = userQuantity;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "FilmwebRating{" +
                "id=" + id +
                ", overallRating=" + overallRating +
                ", minRating=" + minRating +
                ", maxRating=" + maxRating +
                ", userQuantity=" + userQuantity +
                ", movie=" + movie.getTitle() +
                '}';
    }
}
