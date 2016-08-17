package com.charleslabas.games_db.service;

import com.charleslabas.games_db.domain.entity.Game;

import java.util.List;

/**
 * Created by chazzlabs on 7/5/2016.
 */
public interface GameService {

    Game save(Game game);
    List<Game> findAll();
    Game find(Long id);

}
