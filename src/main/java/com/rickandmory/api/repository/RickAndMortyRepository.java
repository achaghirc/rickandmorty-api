package com.rickandmory.api.repository;

import com.rickandmory.api.model.Character;
import com.rickandmory.api.model.Episode;

import java.util.List;

public interface RickAndMortyRepository {


    List<Character> getCharacterByName(String name);


    Episode getEpisodeById(String id);
}
