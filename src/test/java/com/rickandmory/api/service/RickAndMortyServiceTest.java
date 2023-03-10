package com.rickandmory.api.service;

import com.rickandmory.api.model.Character;
import com.rickandmory.api.model.Episode;
import com.rickandmory.api.model.Response;
import com.rickandmory.api.repository.RickAndMortyRepository;
import com.rickandmory.api.service.impl.RickAndMortyServiceImpl;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amine
 * @version 0.0.1
 * This class is to test unitary the Rick And Morty Service.
 */
public class RickAndMortyServiceTest {

    private static final String name = "Rick Sanchez";
    private static final String episodeName = "Pilot";
    private static final String episodeURI = "https://rickandmortyapi.com/api/episode/1";
    private static final String airDate = "December, 17 2017";
    private static final String id = "1";


    @InjectMocks
    private RickAndMortyServiceImpl service;

    @Mock
    private RickAndMortyRepository repository;

    List<Response> responses;
    List<Character> characters;
    Character character;
    Response response;
    Episode episode;

    /**
     * @author amine
     * Setup al the necessary data before every test execution.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        character = new Character();
        character.setEpisode(List.of(episodeURI));
        character.setName(name);

        episode = new Episode();
        episode.setName(episodeName);
        episode.setAir_date(airDate);


        response = new Response();
        response.setName(name);
        response.setEpisodes(List.of(episodeName));
        response.setFirstAppearance(airDate);


        responses = List.of(response);
        characters = List.of(character);
    }

    /**
     * @author amine
     * This test tests the method to get the Data in a Response object when the method getRickAndMortyData is called passing a name like a param.
     * In this test the method returns a list with the builded response.
     */
    @Test
    public void getRickAndMortyData_by_name_return_data() {
        Mockito.when(repository.getCharacterByName(name)).thenReturn(characters);
        Mockito.when(repository.getEpisodeById(id)).thenReturn(episode);

        List<Response> responseList = service.getRickAndMortyData(name);

        MatcherAssert.assertThat(responseList.size(), Matchers.greaterThanOrEqualTo(1));
        MatcherAssert.assertThat(responseList.get(0).getName(), Matchers.is(response.getName()));
    }


    /**
     * @author amine
     * This test tests the method to get the Data in a Response object when the method getRickAndMortyData is called passing a name like a param.
     * In this test the method returns an empty list because when the repository is called returns an empty list of characters, so no data is found to
     * return in a response.
     */
    @Test
    public void getRickAndMortyData_by_name_return_empty() {
        Mockito.when(repository.getCharacterByName(name)).thenReturn(new ArrayList<>());

        List<Response> responseList = service.getRickAndMortyData(name);

        MatcherAssert.assertThat(responseList.size(), Matchers.is(0));
    }

}
