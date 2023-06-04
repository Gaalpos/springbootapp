package com.cuaderno1.cuaderno1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cuaderno1.cuaderno1.models.CharacterModel;
import com.cuaderno1.cuaderno1.utils.Utils;

@Service
public class RickAndMortyService {

    @Autowired
    RestTemplate restTemplate;

    final static String BASE_API = "https://rickandmortyapi.com/api";
   
    final int TOTAL_CHARACTERS = 826;

    public CharacterModel getRandomCharacter (){
        
        int random = Utils.getRandomValue(TOTAL_CHARACTERS-1)+1;
        String url = "/character/" + random;
        CharacterModel datos = restTemplate.getForObject(BASE_API+url, CharacterModel.class);
        return datos;

    }

    public CharacterModel getCharacter(int num){
        String url = "/character/"+ num;
        CharacterModel datos = restTemplate.getForObject(BASE_API+url, CharacterModel.class);
        return datos;
    }


    
}
