package com.example.dbfinal.albums;

import com.example.dbfinal.artists.Artist;
import com.example.dbfinal.songs.Song;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ManyToOne
    private Artist artistId;

    @OneToMany(mappedBy = "albumId")
    @JsonIgnore
    private List<Song> songs;

    public Album() {};

    public Album( String title, Artist artist) {
        this.title = title;
        this.artistId = artist;
        this.songs = new ArrayList<>();
    }


    public List<Song> getSongs() {
        return songs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtistId() {
        return artistId;
    }

    public void setArtistId(Artist artistId) {
        artistId = artistId;
    }
}
