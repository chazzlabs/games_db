package com.charleslabas.games_db.repository;

import com.charleslabas.games_db.domain.entity.Publisher;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by chazzlabs on 6/30/2016.
 */
public interface PublisherRepository extends PagingAndSortingRepository<Publisher, Long> {

    Publisher findByName(String name);
    List<Publisher> findAll();

}
