package com.techbuzz.camel.firstcamelproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AdviceSlipResponseDto {

    @JsonProperty("slip")
    private SlipResponseDto slipResponseDto;
}
