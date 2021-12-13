package com.example.dbfinal.artists;

import com.example.dbfinal.songs.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ArtistRepository extends
        CrudRepository<Artist, Integer> {
    @Query(value = "SELECT * FROM artists WHERE id_artist=:idArtist", nativeQuery = true)
    public Artist findArtistById(@Param("idArtist") Integer id);
}

