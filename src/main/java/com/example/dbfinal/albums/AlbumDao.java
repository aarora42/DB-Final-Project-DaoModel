package com.example.dbfinal.albums;

import com.example.dbfinal.artists.Artist;
import com.example.dbfinal.artists.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AlbumDao {
    @Autowired
    ArtistRepository artistRepository;

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/api/artists/{aid}/albums")
    public List<Album> findAlbumsByArtist(
            @PathVariable("aid")
                    Integer idArtist) {

        return artistRepository
                .findById(idArtist).get()
                .getAlbums();
    }

    @GetMapping("/api/albums")
    public List<Album> findAllAlbums() {
        return (List<Album>)albumRepository.findAll();
    }


    @GetMapping("/api/albums/{idAlbum}")
    public Album findAlbumById(
            @PathVariable("idAlbum") Integer idAlbum) {
        return albumRepository.findAlbumById(idAlbum);
    }


    @PostMapping("api/albums/create/{title}/{artist}")
    public Album createAlbum(
            @PathVariable("title") String title,
            @PathVariable("artist")  Artist artist) {
        Album album = new Album(title, artist);
        return albumRepository.save(album);
    }


    @DeleteMapping("api/albums/delete/{idAlbum}")
    public void deleteAlbum(
            @PathVariable("idAlbum") Integer id) {
        albumRepository.deleteById(id);
    }


    @PutMapping("/api/albums/update/{idAlbum}/{title}")
    public Album updateAlbum(
            @PathVariable("idAlbum") Integer id,
            @PathVariable("title") String title) {
        Album album = albumRepository.findAlbumById(id);
        album.setTitle(title);
        return albumRepository.save(album);
    }

}

