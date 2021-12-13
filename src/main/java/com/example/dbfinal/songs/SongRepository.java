package com.example.dbfinal.songs;

import com.example.dbfinal.artists.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SongRepository extends
        CrudRepository<Song, Integer> {
    @Query(value = "SELECT * FROM songs WHERE id_songs=:idSongs", nativeQuery = true)
    public Song findSongById(@Param("idSongs") Integer id);
}