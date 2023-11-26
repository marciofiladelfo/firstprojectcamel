package com.techbuzz.camel.firstcamelproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RickAndMortyResponseDto {
    @JsonProperty("id")
    private Integer characterId;

    @JsonProperty("name")
    private String characterName;

    @JsonProperty("status")
    private String characterStatus;

    @JsonProperty("species")
    private String characterSpecies;

}
