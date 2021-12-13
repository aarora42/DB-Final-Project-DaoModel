package com.example.dbfinal.artists;

import com.example.dbfinal.albums.Album;
import com.example.dbfinal.songs.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ArtistDao {
    @Autowired
    ArtistRepository artistRepository;
    @GetMapping("/api/artists")
    public List<Artist> findAllArtists() {
        return (List<Artist>) artistRepository.findAll();
    }


    @GetMapping("/api/artists/{idArtist}")
    public Artist findArtistById(
            @PathVariable("idArtist") Integer idArtist) {
        return artistRepository.findArtistById(idArtist);
    }


    @PostMapping("api/artists/create/{fn}/{ln}/{user}/{pw}/{e}/{dob}")
    public Artist createArtist(
            @PathVariable("fn") String firstName,
            @PathVariable("ln")  String lastName,
            @PathVariable("user") String user,
            @PathVariable("pw") String pw,
            @PathVariable("e") String email,
            @PathVariable("dob") Date dateOfBirth) {
        Artist artist = new Artist(firstName, lastName, user, pw, email, dateOfBirth);
        return artistRepository.save(artist);
    }


    @DeleteMapping("api/artists/delete/{idArtist}")
    public void deleteArtist(
            @PathVariable("idArtist") Integer id) {
        artistRepository.deleteById(id);
    }


    @PutMapping("/api/artists/update/{idArtist}/{password}")
    public Artist updateArtist(
            @PathVariable("idArtist") Integer id,
            @PathVariable("password") String pw) {
        Artist artist = artistRepository.findArtistById(id);
        artist.setPassword(pw);
        return artistRepository.save(artist);
    }
}

