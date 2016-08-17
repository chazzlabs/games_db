package com.charleslabas.games_db.web;

import com.charleslabas.games_db.domain.entity.Game;
import com.charleslabas.games_db.service.GameService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chazzlabs on 7/5/2016.
 */
@RestController
public class GameController {

    private static final String GAMES = "/games";

    @Autowired
    private GameService gameService;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = GAMES, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonNode> getGames() {
        return new ResponseEntity<>((JsonNode) objectMapper.valueToTree(gameService.findAll()), HttpStatus.OK);
    }

    @RequestMapping(value = GAMES + "/{gameId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonNode> getGame(@PathVariable long gameId) {
        Game game = gameService.find(gameId);

        if (game == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>((JsonNode) objectMapper.valueToTree(game), HttpStatus.OK);
        }
    }

    @RequestMapping(value = GAMES, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonNode> createGame(@RequestBody Game game) {
        JsonNode mappedValue = objectMapper.valueToTree(gameService.save(game));
        return new ResponseEntity<>(mappedValue, HttpStatus.OK);
    }

}
