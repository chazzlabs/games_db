package com.charleslabas.games_db.config;

import com.charleslabas.games_db.domain.entity.Developer;
import com.charleslabas.games_db.domain.entity.Game;
import com.charleslabas.games_db.domain.entity.Genre;
import com.charleslabas.games_db.domain.entity.Publisher;
import com.charleslabas.games_db.repository.DeveloperRepository;
import com.charleslabas.games_db.repository.GameRepository;
import com.charleslabas.games_db.repository.GenreRepository;
import com.charleslabas.games_db.repository.PublisherRepository;
import com.charleslabas.games_db.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * Created by chazzlabs on 7/5/2016.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.charleslabas.games_db.repository")
public class PersistanceConfig {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private GameService gameService;

    /*
        Do some initialization here to experiment with entity creation and saving while giving us some
        content to work with in our database.
    */
    private void createDevelopers() {
        String[] developers = {"Blizzard Entertainment", "Moppin", "Nintendo EAD"};
        Arrays.stream(developers).forEach(developer -> developerRepository.save(new Developer(developer, null)));
    }

    private void createPublishers() {
        String[] publishers = {"Blizzard Entertainment", "Devolver Digital", "Nintendo"};
        Arrays.stream(publishers).forEach(publisher -> publisherRepository.save(new Publisher(publisher, null)));
    }

    private void createGenres() {
        String[] genres = {"MMORPG", "First-Person Shooter", "Platformer", "Shoot 'Em Up"};
        Arrays.stream(genres).forEach(genre -> genreRepository.save(new Genre(genre, null)));
    }

    private void createGame(String gameName, String developerName, String publisherName) {
        Game game = new Game(
                gameName,
                new Developer(developerName, null),
                new Publisher(publisherName, null),
                null, null
        );

        gameService.save(game);
    }

    @PostConstruct
    public void initDB() throws Exception {
        createDevelopers();
        createPublishers();
        createGenres();

        createGame("World of Warcraft", "Blizzard Entertainment", "Blizzard Entertainment");
    }
}
