package com.techbuzz.camel.firstcamelproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class SlipResponseDto {
    @JsonProperty("id")
    private Integer characterId;

    @JsonProperty("advice")
    private String characterName;

}
