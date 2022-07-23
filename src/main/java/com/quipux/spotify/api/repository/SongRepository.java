package com.quipux.spotify.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quipux.spotify.api.entity.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

}
