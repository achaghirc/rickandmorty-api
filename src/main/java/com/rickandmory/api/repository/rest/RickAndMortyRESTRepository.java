package com.rickandmory.api.repository.rest;

import com.rickandmory.api.model.Character;
import com.rickandmory.api.model.Episode;
import com.rickandmory.api.model.SearchResponse;
import com.rickandmory.api.repository.RickAndMortyRepository;
import com.rickandmory.api.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RickAndMortyRESTRepository implements RickAndMortyRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(RickAndMortyRESTRepository.class);

    @Autowired
    private WebClient restApiClient;


    @Override
    public List<Character> getCharacterByName(String name) {
        try{
            SearchResponse res = restApiClient.get().uri(uriBuilder -> {
                uriBuilder.path(Utils.CHARACTER_PATH)
                        .queryParam(Utils.NAME_PARAM, name);
                return uriBuilder.build();
            }).retrieve().bodyToMono(new ParameterizedTypeReference<SearchResponse>() {}).block();
            assert res != null;
            return  res.getResults();
        }catch (Exception e){
            LOGGER.error("There is an unexpected error: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Episode getEpisodeById(String id) {
        try{
            return restApiClient.get().uri(Utils.EPISODE_PATH + "/" + Long.valueOf(id))
                    .retrieve().bodyToMono(new ParameterizedTypeReference<Episode>() {}).block();
        }catch (Exception e){
            LOGGER.error("There is an unexpected error: " + e.getMessage());
            return null;
        }
    }
}
