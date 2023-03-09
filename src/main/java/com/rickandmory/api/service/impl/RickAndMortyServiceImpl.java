package com.rickandmory.api.service.impl;

import com.rickandmory.api.model.Character;
import com.rickandmory.api.model.Episode;
import com.rickandmory.api.model.Response;
import com.rickandmory.api.repository.RickAndMortyRepository;
import com.rickandmory.api.service.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RickAndMortyServiceImpl implements RickAndMortyService {

    @Autowired
    private RickAndMortyRepository rickAndMortyRepository;

    @Override
    public List<Response> getRickAndMortyData(String name) {
        List<Response> responses = new ArrayList<>();

        List<Character> characters = rickAndMortyRepository.getCharacterByName(name);
        if (characters.isEmpty()) {
            return responses;
        }
        for (Character character : characters) {
            Response response = new Response();
            List<String> episodesNames = new ArrayList<>();
            response.setName(character.getName());
            for (String episodeURI : character.getEpisode()) {
                String id = episodeURI.split("/")[5];
                Episode episode = rickAndMortyRepository.getEpisodeById(id);
                episodesNames.add(episode.getName());
                if (response.getFirstAppearance() == null)
                    response.setFirstAppearance(episode.getAir_date());
            }
            response.setEpisodes(episodesNames);
            responses.add(response);
        }
        return responses;
    }
}
