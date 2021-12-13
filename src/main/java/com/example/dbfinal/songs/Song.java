package com.example.dbfinal.songs;

import com.example.dbfinal.albums.Album;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "songs")
public class Song {
    enum Genre {
        rnb, pop, rap, hipHop, country, kPop;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSongs;
    private String title;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToOne
    private Album albumId;

    public Song(String title, Genre genre, Album album) {
        this.title = title;
        this.genre = genre;
        this.albumId = album;
    }
    public Song() {}

    public Integer getIdSongs() {
        return idSongs;
    }

    public void setIdSongs(Integer idSongs) {
        this.idSongs = idSongs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Album getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Album albumId) {
        this.albumId = albumId;
    }

}
