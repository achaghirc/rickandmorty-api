package com.rickandmory.api.controller;

import com.rickandmory.api.model.Response;
import com.rickandmory.api.service.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping(path = "/search-character-appearance")
    public ResponseEntity<?> getRickAndMortyInfo(@RequestParam(name = "name") String name) {
        List<Response> response = rickAndMortyService.getRickAndMortyData(name);
        if (response.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(response);
        }
    }
}
