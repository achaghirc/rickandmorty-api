package com.rickandmory.api.controller;

import com.rickandmory.api.model.Response;
import com.rickandmory.api.service.RickAndMortyService;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amine
 * @version 0.0.1
 * This class is to test unitary the Rick And Morty Controller.
 */
public class RickAndMortyControllerTest {


    @InjectMocks
    private RickAndMortyController controller;

    @Mock
    private RickAndMortyService service;


    private Response response;
    private static final String name = "Rick Sanchez";

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        response = new Response();
        response.setName("Rick Sanchez");
        response.setFirstAppearance("December, 17 2012");
        response.setEpisodes(List.of("Pilot"));
    }

    /**
     * This test tests the method getRickAndMortyInfo when the service returns a list on responses and the http status code is 200.
     */
    @Test
    public void testGetRickAndMortyInfo_success() {
        Mockito.when(service.getRickAndMortyData(name)).thenReturn(List.of(response));

        ResponseEntity<?> resEntity = controller.getRickAndMortyInfo(name);


        MatcherAssert.assertThat(resEntity.getStatusCode(), Matchers.is(HttpStatus.OK));
        MatcherAssert.assertThat(resEntity.getBody(), Matchers.is(List.of(response)));
    }

    /**
     * This test tests the method getRickAndMortyInfo when the service not found any content with the given name, so it returns a empty list
     * and the HttpStatusCode is NO_CONTENT 204.
     */
    @Test
    public void testGetRickAndMortyInfo_no_content() {
        Mockito.when(service.getRickAndMortyData(name)).thenReturn(new ArrayList<>());

        ResponseEntity<?> resEntity = controller.getRickAndMortyInfo(name);

        MatcherAssert.assertThat(resEntity.getStatusCode(), Matchers.is(HttpStatus.NO_CONTENT));
    }


}
