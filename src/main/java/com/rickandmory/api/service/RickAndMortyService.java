package com.rickandmory.api.service;

import com.rickandmory.api.model.Response;

import java.util.List;

public interface RickAndMortyService {

    List<Response> getRickAndMortyData(String name);

}
