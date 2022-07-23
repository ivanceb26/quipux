package com.quipux.spotify.api.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quipux.spotify.api.dto.PlaylistDTO;
import com.quipux.spotify.api.dto.SongDTO;
import com.quipux.spotify.api.entity.Playlist;
import com.quipux.spotify.api.entity.Song;

@Component("DtoToEntityConverter")
public class DtoToEntityConverter {
	@Autowired
	private ModelMapper modelMapper;
	
	public Playlist mapperToPlaylist(PlaylistDTO playlistDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Playlist playlist = null;
		if(playlistDTO != null) {
			playlist = modelMapper.map(playlistDTO, Playlist.class);
		}
		return playlist;
	}
	
	public Song mapperToSong(SongDTO songDTO) {
		Song song = null;
		if(songDTO != null) {
			song = modelMapper.map(songDTO, Song.class);
		}
		return song;
	}
}
