package com.cuaderno1.cuaderno1.models;

import javax.naming.spi.DirStateFactory.Result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeocodingResponse {

    @JsonProperty("results")
    private Result[] results;

    
    
}
