package com.rickandmory.api.model;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;


/**
 * This class test the class Character making a unit test of his methods getter and setter.
 */
public class CharacterTest {

    @Test
    public void testCharacter() {

        Character character = new Character();
        LocalDate now = LocalDate.now();

        Long id = 1L;
        String name = "Rick";
        String status = "Alive";
        String species = "Human";
        String type = "NO INFO";
        String gender = "Male";
        BaseInfo origin = new BaseInfo();
        BaseInfo location = new BaseInfo();
        String image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg";
        String episode = "Rick";
        List<String> url = List.of( "https://rickandmortyapi.com/api/episode/1");

        character.setId(id);
        character.setName(name);
        character.setStatus(status);
        character.setSpecies(species);
        character.setType(type);
        character.setGender(gender);
        character.setOrigin(origin);
        character.setLocation(location);
        character.setImage(image);
        character.setEpisode(episode);
        character.setUrl(url);
        character.setCreated(now);

        MatcherAssert.assertThat(character.getId(), Matchers.is(id));
        MatcherAssert.assertThat(character.getName(), Matchers.is(name));
        MatcherAssert.assertThat(character.getStatus(), Matchers.is(status));
        MatcherAssert.assertThat(character.getSpecies(), Matchers.is(species));
        MatcherAssert.assertThat(character.getType(), Matchers.is(type));
        MatcherAssert.assertThat(character.getGender(), Matchers.is(gender));
        MatcherAssert.assertThat(character.getOrigin(), Matchers.is(origin));
        MatcherAssert.assertThat(character.getLocation(), Matchers.is(location));
        MatcherAssert.assertThat(character.getImage(), Matchers.is(image));
        MatcherAssert.assertThat(character.getEpisode(), Matchers.is(episode));
        MatcherAssert.assertThat(character.getUrl(), Matchers.is(url));
        MatcherAssert.assertThat(character.getCreated(), Matchers.is(now));
    }
}
