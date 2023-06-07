package com.cuaderno1.cuaderno1.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cuaderno1.cuaderno1.models.MusicModel;
import com.cuaderno1.cuaderno1.services.MusicService;


@RestController
public class musicController {

    @Autowired
    MusicService musicService;

    @GetMapping("/songs")
    public String music(){
        String tmp = "";
        for(MusicModel game: musicService.getAllSongs()){
            tmp += game.getSong();
            tmp += " :  ";
            tmp += game.getArtist();
            tmp += "<br/>";
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
