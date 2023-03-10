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

    /***
     * This method through the rest repository connects to the rick and morty API.
     * First it get the characters based on the provided name param.
     * If no characters found, it will return the empty list.
     * If characters are found, iterates to get the name of the character, the episode name iterating the character's episode list
     * and the first appearance basically taking the date of the first character appearance on an episode.
     * @param name The name to search.
     * @return  List of Response with the data of the characters based on the provided name param.
     */
    @Override
    public List<Response> getRickAndMortyData(String name) {
        List<Response> responses = new ArrayList<>();

        List<Character> characters = rickAndMortyRepository.getCharacterByName(name);
        if (characters.isEmpty()) {
            return responses;
        }
        characters.forEach((character -> {
            Response response = new Response();
            List<String> episodesNames = new ArrayList<>();
            response.setName(character.getName());
            character.getEpisode().forEach((episodeURI) -> {
                String id = episodeURI.split("/")[5];
                Episode episode = rickAndMortyRepository.getEpisodeById(id);
                episodesNames.add(episode.getName());
                if (response.getFirstAppearance() == null)
                    response.setFirstAppearance(episode.getAir_date());
            });
            response.setEpisodes(episodesNames);
            responses.add(response);
        }));

        return responses;
    }
}
