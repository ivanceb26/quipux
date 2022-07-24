package com.quipux.spotify.api.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.quipux.spotify.api.dto.PlaylistDTO;
import com.quipux.spotify.api.dto.SongDTO;
import com.quipux.spotify.api.entity.Playlist;
import com.quipux.spotify.api.entity.Song;

@Mapper
public interface PlaylistMapper {
	PlaylistMapper MAPPER = Mappers.getMapper( PlaylistMapper.class );
    
	PlaylistDTO playlistToPlaylistDTO(Playlist playlist);

    Playlist playlistDTOToPlaylist(PlaylistDTO playlistDTO);
    
    SongDTO songToSongDTO(Song song);
    
    Song songDTOToSong(SongDTO songDTO);
}