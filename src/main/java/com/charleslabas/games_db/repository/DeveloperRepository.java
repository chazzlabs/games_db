package com.charleslabas.games_db.repository;

import com.charleslabas.games_db.domain.entity.Developer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by chazzlabs on 6/30/2016.
 */
public interface DeveloperRepository extends PagingAndSortingRepository<Developer, Long> {

    Developer findByName(String name);
    List<Developer> findAll();

}
