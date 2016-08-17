package com.charleslabas.games_db.domain.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by chazzlabs on 6/30/2016.
 */
@Entity
public class Game extends BaseEntity {

    private String name;

    @ManyToOne
    private Developer developer;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Genre> genres;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
//    private List<Genre> genres = new ArrayList();

    public Game() {}

    public Game(String name, Developer developer, Publisher publisher, List<Genre> genres, Date releaseDate) {
        this.name = name;
        this.developer = developer;
        this.publisher = publisher;
        this.genres = genres;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
