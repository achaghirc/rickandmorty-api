package com.rickandmory.api.model;

import java.util.List;

public class SearchResponse {

    private Info info;
    private List<Character> results;


    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }
}
