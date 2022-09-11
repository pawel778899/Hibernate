package hibernate.model;

import javax.persistence.*;


@Entity
@Table(name = "courses")
public class Course {


    @Id
    @Column(name = "id", columnDefinition = "BIGINT")
    private  int id;

    @Column(name = "name")
    private String name;

    @Column(name = "place")
    private String place;

    @Column(name = "term", columnDefinition = "TINYINT")
    private int term;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", term=" + term +
                ", teacher=" + teacher +
                '}';
    }
}
