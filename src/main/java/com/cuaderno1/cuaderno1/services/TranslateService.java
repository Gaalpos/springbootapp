package com.cuaderno1.cuaderno1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cuaderno1.cuaderno1.models.TranslateModel;

@Service
public class TranslateService {

    @Autowired
    static
    RestTemplate restTemplate;


    final static String BASE_API_1 = "https://api.mymemory.translated.net/get?q=";
    final static String BASE_API_2 = "&langpair=es|en";
    
    
    public static TranslateModel translate (String frase){
    String cadena = frase;
    TranslateModel datos = restTemplate.getForObject(BASE_API_1+cadena+BASE_API_2, TranslateModel.class);
    return datos;

    }
}
