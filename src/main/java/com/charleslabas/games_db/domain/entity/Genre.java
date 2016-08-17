package com.charleslabas.games_db.domain.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by chazzlabs on 6/30/2016.
 */
@Entity
public class Genre extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "genres")
    private List<Game> games;

    public Genre() {}

    public Genre(String name, List<Game> games) {
        this.name = name;
        this.games = games;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
