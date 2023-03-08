package com.rickandmory.api.model;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

/**
 * This class test the class Response making a unit test of his methods getter and setter.
 */
public class ResponseTest {

    @Test
    public void testResponse() {
        Response response = new Response();
        LocalDate now = LocalDate.now();
        String name = "Rick Sanchez";
        List<String> episodes = List.of("https://rickandmortyapi.com/api/episode/1");

        response.setName(name);
        response.setEpisodes(episodes);
        response.setFirstAppearance(now);


        MatcherAssert.assertThat(response.getName(), Matchers.is(name));
        MatcherAssert.assertThat(response.getEpisodes(), Matchers.is(episodes));
        MatcherAssert.assertThat(response.getFirstAppearance(), Matchers.is(now));

    }

}
