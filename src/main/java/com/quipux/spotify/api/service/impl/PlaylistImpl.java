package com.quipux.spotify.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.quipux.spotify.api.converter.DtoToEntityConverter;
import com.quipux.spotify.api.converter.EntityToDtoConverter;
import com.quipux.spotify.api.dto.PlaylistDTO;
import com.quipux.spotify.api.dto.SongDTO;
import com.quipux.spotify.api.entity.Playlist;
import com.quipux.spotify.api.entity.Song;
import com.quipux.spotify.api.repository.PlaylistRepository;
import com.quipux.spotify.api.service.IPlaylist;

@Service
public class PlaylistImpl implements IPlaylist {
	
	@Autowired
	@Qualifier("playlistRepository")
	private PlaylistRepository playlistRepository;
	
	@Autowired
	private EntityToDtoConverter entityToDtoConverter;
	
	@Autowired
	private DtoToEntityConverter dtoToEntityConverter;

	@Override
	public String getPlaylistInfo() {
		// TODO Auto-generated method stub
		return "Esta es la primer playlist";
	}

	@Override
	public List<PlaylistDTO> getPlaylists() {
		List<PlaylistDTO> playlistsDTO = null;
		List<Playlist> playlists = playlistRepository.findAll();
		playlistsDTO = playlists.stream().map(param -> entityToDtoConverter.mapperToPlaylistDTO(param)).collect(Collectors.toList());
		return playlistsDTO;
	}
	
	@Override
	public PlaylistDTO getPlaylistByQuery(String listName) {
		return null;
	}

	@Override
	public PlaylistDTO createPlaylistInfo(PlaylistDTO playlistDTO) {
		Playlist playlistEntity = new Playlist();
		playlistEntity.setDescription(playlistDTO.getDescription());
		playlistEntity.setName(playlistDTO.getName());
		
		List<Song> songs = playlistDTO.getSongs().stream().map(param -> dtoToEntityConverter.mapperToSong(param)).collect(Collectors.toList());
		playlistEntity.setSongs(songs);
		
		playlistRepository.save(playlistEntity);
		
		return entityToDtoConverter.mapperToPlaylistDTO(playlistEntity);
	}

	@Override
	public boolean deletePlaylistInfo(String listName) {
		// TODO Auto-generated method stub
		return false;
	}

}
