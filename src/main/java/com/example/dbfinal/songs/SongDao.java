package com.example.dbfinal.songs;

import com.example.dbfinal.albums.Album;
import com.example.dbfinal.albums.AlbumRepository;
import com.example.dbfinal.artists.Artist;
import com.example.dbfinal.artists.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class SongDao {
    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/api/albums/{aid}/songs")
    public List<Song> findSongsByAlbum(
            @PathVariable("aid")
                    Integer idAlbum) {

        return albumRepository
                .findById(idAlbum).get()
                .getSongs();
    }

    @GetMapping("/api/songs")
    public List<Song> findAllSongs() {
        return (List<Song>)songRepository.findAll();
    }

    @PostMapping("api/songs/create/{title}/{genre}/{album}")
    public Song createSong(
           @PathVariable("title") String title,
           @PathVariable("genre")  Song.Genre genre,
           @PathVariable("album") Album album) {
        Song song = new Song(title, genre, album);
        return songRepository.save(song);
    }

    @GetMapping("/api/songs/{idSongs}")
    public Song findSongById(
            @PathVariable("idSongs") Integer idSongs) {
        return songRepository.findSongById(idSongs);
    }

    //Check this with professor
    @DeleteMapping("api/songs/delete/{idSongs}")
    public void deleteSong(
            @PathVariable("idSongs") Integer id) {
        songRepository.deleteById(id);
    }

    //Check with professor
    @PutMapping("/api/songs/update/{idSongs}/{genre}")
    public Song updateSong(
            @PathVariable("idSongs") Integer id,
            @PathVariable("genre") Song.Genre newGenre) {
        Song song = songRepository.findSongById(id);
        song.setGenre(newGenre);
        return songRepository.save(song);
    }




}

