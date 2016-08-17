package com.charleslabas.games_db.repository;

import com.charleslabas.games_db.domain.entity.Genre;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by chazzlabs on 7/5/2016.
 */
public interface GenreRepository extends PagingAndSortingRepository<Genre, Long> {

    Genre findByName(String name);
    List<Genre> findAll();

}
