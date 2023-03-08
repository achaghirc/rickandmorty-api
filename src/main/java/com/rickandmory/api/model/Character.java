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
}
