package com.cuaderno1.cuaderno1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cuaderno1.cuaderno1.models.CharacterModel;
import com.cuaderno1.cuaderno1.services.RickAndMortyService;

@RestController
public class rickController {

    @Autowired
    RickAndMortyService rickAndMortyService;

    @GetMapping("rickandmorty/random")
    public String randomCharaceter(){

        CharacterModel characterModel = rickAndMortyService.getRandomCharacter();
        String locationName = characterModel.location.name;

        return characterModel.name +"</br>" + "<img width='200' src='"+characterModel.image+"'/>" + "</br>"+ locationName;
    }

    @GetMapping("rickandmorty")
    public String characeter(@RequestParam int id){
        CharacterModel characterModel = rickAndMortyService.getCharacter(id);
        String locationName = characterModel.location.name;
        return characterModel.name + "<br/>" + "<img width='200' src='"+characterModel.image+"'/>" + "</br>"+ locationName;

    }
    
}
