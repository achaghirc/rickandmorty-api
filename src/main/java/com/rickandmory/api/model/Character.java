package com.rickandmory.api.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class Character {

    private Long id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private BaseInfo origin;
    private BaseInfo location;
    private String image;
    private String episode;
    private List<String> url;
    @DateTimeFormat(pattern = "yyyy-mm-ddTHH:mm:ss.sssZ")
    private LocalDate created;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public BaseInfo getOrigin() {
        return origin;
    }

    public void setOrigin(BaseInfo origin) {
        this.origin = origin;
    }

    public BaseInfo getLocation() {
        return location;
    }

    public void setLocation(BaseInfo location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }
}
