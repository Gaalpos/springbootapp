package com.cuaderno1.cuaderno1.models;

public class CityModel {
    private int id;
    private int population;


    public CityModel (){
        
    }
    public CityModel(int id, int population) {
        this.id = id;
        this.population = population;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }

    
    
}

