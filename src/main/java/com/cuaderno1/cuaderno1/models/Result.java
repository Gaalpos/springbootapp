package com.cuaderno1.cuaderno1.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    private int id;
    private int population;

    // Constructor, getters y setters

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("population")
    public void setPopulation(int population) {
        this.population = population;
    }
}
