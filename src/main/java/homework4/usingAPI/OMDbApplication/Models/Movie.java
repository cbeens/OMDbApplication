package homework4.usingAPI.OMDbApplication.Models;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "movies")
public class Movie {

    //Field variables
    @Id
    @org.hibernate.annotations.Type(type="uuid-char") //this handles the type conversion of UUIDs between DB and app
    @Column(name="id")
    private UUID id;
    @Column(name="title")
    private String title;
    @Column(name="director")
    private String director;
    @Column(name="description")
    private String desc;
    @Column(name="genre")
    private String genre;
    @Column(name="rating")
    private String rating;
    @Column(name="poster")
    private String poster;

    //Constructors
    public Movie(){} //default constructor

    //Getters and Setters
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPoster() {
        return poster;
    }
    public void setPoster(String poster) {
        this.poster = poster;
    }
}
