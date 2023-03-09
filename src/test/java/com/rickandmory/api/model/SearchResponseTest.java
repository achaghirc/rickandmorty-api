package com.rickandmory.api.model;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SearchResponseTest {
    @Test
    public void testSearchResponse() {

        SearchResponse searchResponse = new SearchResponse();
        Info info = new Info();
        List<Character> results = List.of(new Character());
        searchResponse.setInfo(info);
        searchResponse.setResults(results);


        MatcherAssert.assertThat(searchResponse.getInfo(), Matchers.is(info));
        MatcherAssert.assertThat(searchResponse.getResults(), Matchers.is(results));

    }

}
