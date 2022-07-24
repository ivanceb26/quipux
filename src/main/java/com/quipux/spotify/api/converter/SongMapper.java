package com.quipux.spotify.api.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.quipux.spotify.api.dto.PlaylistDTO;
import com.quipux.spotify.api.dto.SongDTO;
import com.quipux.spotify.api.entity.Playlist;
import com.quipux.spotify.api.entity.Song;

@Mapper
public interface SongMapper {
	SongMapper MAPPER = Mappers.getMapper( SongMapper.class );

    //@Mapping(target = "playlists", ignore = true)
    Song songDTOToSong(SongDTO songDTO);
    
    SongDTO songToSongDTO(Song song);
}