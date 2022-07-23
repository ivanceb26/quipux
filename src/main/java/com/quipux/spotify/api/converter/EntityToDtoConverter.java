package com.quipux.spotify.api.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quipux.spotify.api.dto.PlaylistDTO;
import com.quipux.spotify.api.dto.SongDTO;
import com.quipux.spotify.api.entity.Playlist;
import com.quipux.spotify.api.entity.Song;

@Component("EntityToDtoConverter")
public class EntityToDtoConverter {
	@Autowired
	private ModelMapper modelMapper;
	
	public PlaylistDTO mapperToPlaylistDTO(Playlist playlist) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		PlaylistDTO playlistDTO = null;
		if(playlist != null) {
			playlistDTO = modelMapper.map(playlist, PlaylistDTO.class);
		}
		return playlistDTO;
	}
	
	public SongDTO mapperToSongDTO(Song song) {
		SongDTO songDTO = null;
		if(song != null) {
			songDTO = modelMapper.map(song, SongDTO.class);
		}
		return songDTO;
	}
}
