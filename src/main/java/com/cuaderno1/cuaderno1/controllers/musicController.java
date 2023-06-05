package com.cuaderno1.cuaderno1.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cuaderno1.cuaderno1.models.MusicModel;
import com.cuaderno1.cuaderno1.repositories.MusicRepository;
import com.cuaderno1.cuaderno1.services.MusicService;

import ch.qos.logback.core.model.Model;

@RestController
public class musicController {

    @Autowired
    MusicService musicService;

    @GetMapping("/songs")
    public String videogames(){
        String tmp = "";
        for(MusicModel game: musicService.getAllSongs()){
            tmp += game.getSong();
            tmp += "<br/>";
            tmp += game.getArtist();
            tmp += "<br/>";
        }
        return tmp;
    }


    @PostMapping("/addsong")
    public String addSong(@RequestParam Map<String, String> body){

        String song = body.get("song");
        String artist = body.get("artist");

        MusicModel cancion = new MusicModel();
        cancion.setSong(song);
        cancion.setArtist(artist);

        musicService.createSong(cancion);
        return "cancion guardada";

    }




    
}
