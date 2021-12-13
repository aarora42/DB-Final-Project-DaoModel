package com.example.dbfinal.albums;

import com.example.dbfinal.artists.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AlbumRepository extends
        CrudRepository<Album, Integer> {
    @Query(value = "SELECT * FROM albums WHERE id=:idAlbum", nativeQuery = true)
    public Album findAlbumById(@Param("idAlbum") Integer id);
}

