package com.charleslabas.games_db.repository;

import com.charleslabas.games_db.domain.entity.Game;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by chazzlabs on 6/30/2016.
 */
public interface GameRepository extends PagingAndSortingRepository<Game, Long> {

    Game findByName(String name);
    List<Game> findAll();

}
