package com.aqa.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AppResponse(
    @JsonProperty("result") String result,
    @JsonProperty("message") String message
) {

}