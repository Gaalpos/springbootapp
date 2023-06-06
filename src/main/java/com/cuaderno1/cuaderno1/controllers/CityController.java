package com.cuaderno1.cuaderno1.controllers;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cuaderno1.cuaderno1.models.CityModel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CityController {



    @GetMapping("/city")
    public CityModel getFirstResult(@RequestParam("cityName") String cityName) {

        RestTemplate restTemplate = new RestTemplate();
        
        String url = "https://geocoding-api.open-meteo.com/v1/search?name=" + cityName;

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String jsonResponse = response.getBody();

        // Aquí debes proporcionar el código para procesar el JSON y obtener el primer resultado
        // Supongamos que el JSON tiene una estructura similar al JSON original en la pregunta

        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);
            JsonNode resultsNode = jsonNode.get("results");

            if (resultsNode.isArray() && resultsNode.size() > 0) {
                JsonNode firstResultNode = resultsNode.get(0);

                int id = firstResultNode.get("id").asInt();
                int population = firstResultNode.get("population").asInt();
                String name = firstResultNode.get("name").asText();

                CityModel city = new CityModel();
                city.setId(id);
                city.setPopulation(population);
                city.setName(name);
                return city;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
