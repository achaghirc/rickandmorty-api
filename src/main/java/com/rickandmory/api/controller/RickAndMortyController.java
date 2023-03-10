package com.rickandmory.api.controller;

import com.rickandmory.api.model.Response;
import com.rickandmory.api.service.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class RickAndMortyController {

    @Autowired
    private RickAndMortyService rickAndMortyService;

    /***
     * API endpoint to get the Characters data based on the name provided by the client.
     * @param name The param to search the data.
     * @return A ResponseEntity with status code 200 and the response list if the service return data.
     * Or a ResponseEntity with status code 204 NO_CONTENT if the service don't return data.
     */
    @GetMapping(path = "/search-character-appearance", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRickAndMortyInfo(@RequestParam(name = "name") String name) {
        List<Response> response = rickAndMortyService.getRickAndMortyData(name);
        if (response.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(response);
        }
    }
}
