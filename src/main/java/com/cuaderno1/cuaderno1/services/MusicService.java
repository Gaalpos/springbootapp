package com.cuaderno1.cuaderno1.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuaderno1.cuaderno1.models.MusicModel;
import com.cuaderno1.cuaderno1.repositories.MusicRepository;

@Service
public class MusicService {

    @Autowired
    MusicRepository musicRepository;

    public  ArrayList<MusicModel> getAllSongs(){
        return (ArrayList<MusicModel>)musicRepository.findAll();
    }


    public  MusicModel createSong(MusicModel song){
        return musicRepository.save(song);
    }



    
}
