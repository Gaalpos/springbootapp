package com.cuaderno1.cuaderno1.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="song")
public class MusicModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique = true, nullable=false)
    private long id;

    @Column(length = 500)
    public String song;
    public String artist;


    public MusicModel() {
        
    }

    public MusicModel(long id, String song, String artist) {
        this.id = id;
        this.song = song;
        this.artist = artist;
    }

    
    public String getSong() {
        return song;
    }
    public void setSong(String song) {
        this.song = song;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    @Override
    public String toString() {
        return "MusicModel [song=" + song + ", artist=" + artist + "]";
    }
    
}
