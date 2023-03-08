package com.rickandmory.api.model;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
/**
 * This class test the class Episode making a unit test of his methods getter and setter.
 */
public class EpisodeTest {

    @Test
    public void testEpisode() {
        Episode episode = new Episode();
        LocalDate now = LocalDate.now();

        Long id = 1L;
        String name = "Rick";
        String airDate = "";
        List<String> characters = List.of( "https://rickandmortyapi.com/api/character/1");
        String url = "https://rickandmortyapi.com/api/episode/1";
        String episodeName = "Episode";

        episode.setId(id);
        episode.setName(name);
        episode.setAirDate(airDate);
        episode.setCharacters(characters);
        episode.setUrl(url);
        episode.setCreated(now);
        episode.setEpisode(episodeName);

        MatcherAssert.assertThat(episode.getId(), Matchers.is(id));
        MatcherAssert.assertThat(episode.getName(), Matchers.is(name));
        MatcherAssert.assertThat(episode.getAirDate(), Matchers.is(airDate));
        MatcherAssert.assertThat(episode.getCharacters(), Matchers.is(characters));
        MatcherAssert.assertThat(episode.getUrl(), Matchers.is(url));
        MatcherAssert.assertThat(episode.getCreated(), Matchers.is(now));
        MatcherAssert.assertThat(episode.getEpisode(), Matchers.is(episodeName));

    }
}
