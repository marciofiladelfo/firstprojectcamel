package com.techbuzz.camel.firstcamelproject.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class RickAndMortyResponseApi {

    private Integer id;

    private String name;

    private String status;

    private String species;

    private String type;

    private String gender;

    private Origin origin;

    private Location location;

    private String image;

    private List<String> episode;

    private String url;

    private String created;
}
