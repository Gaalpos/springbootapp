package com.cuaderno1.cuaderno1.models;

public class CityModel {
    private String name;
    private int id;
    private int population;
 



    public CityModel (){
        
    }
    public CityModel(int id, int population, String name) {
        this.id = id;
        this.population = population;
        this.name = name;
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
    
}

