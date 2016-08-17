package com.charleslabas.games_db.service;

import com.charleslabas.games_db.domain.entity.Developer;
import com.charleslabas.games_db.domain.entity.Game;
import com.charleslabas.games_db.domain.entity.Publisher;
import com.charleslabas.games_db.repository.DeveloperRepository;
import com.charleslabas.games_db.repository.GameRepository;
import com.charleslabas.games_db.repository.PublisherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chazzlabs on 7/5/2016.
 */
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    private static final Logger log = LoggerFactory.getLogger(GameServiceImpl.class);

    private Developer createDeveloper(String developerName) {
        Developer developer = developerRepository.findByName(developerName);

        if (developer == null) {
            developer = new Developer(developerName, null);
            developerRepository.save(developer);
        }

        return developer;
    }

    private Publisher createPublisher(String publisherName) {
        Publisher publisher = publisherRepository.findByName(publisherName);

        if (publisher == null) {
            publisher = new Publisher(publisherName, null);
            publisherRepository.save(publisher);
        }

        return publisher;
    }

    @Transactional
    public Game save(Game game) {
        game.setDeveloper(createDeveloper(game.getDeveloper().getName()));
        game.setPublisher(createPublisher(game.getPublisher().getName()));

        log.info(game.toString());

        return gameRepository.save(game);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Game find(Long id) {
        return gameRepository.findOne(id);
    }
}
