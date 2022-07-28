package com.quipux.spotify.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.quipux.spotify.api.converter.PlaylistMapper;
import com.quipux.spotify.api.dto.PlaylistDTO;
import com.quipux.spotify.api.entity.Playlist;
import com.quipux.spotify.api.handler.RecordNotFoundException;
import com.quipux.spotify.api.repository.PlaylistRepository;
import com.quipux.spotify.api.service.IPlaylist;

@Service
public class PlaylistImpl implements IPlaylist {
	
	@Autowired
	@Qualifier("playlistRepository")
	private PlaylistRepository playlistRepository;

	@Override
	public List<PlaylistDTO> getPlaylists() {
		return playlistRepository.findAll().stream().map(PlaylistMapper.MAPPER::playlistToPlaylistDTO).collect(Collectors.toList());
	}
	
	@Override
	public PlaylistDTO getPlaylistByQuery(String listName) {
		Playlist playlist = playlistRepository.findByName(listName);
		if(playlist==null) {
			throw new RecordNotFoundException("Record Not Found");
		}
		return PlaylistMapper.MAPPER.playlistToPlaylistDTO(playlist);
	}

	@Override
	public PlaylistDTO createPlaylistInfo(PlaylistDTO playlistDTO) {
		
		Playlist playlist = PlaylistMapper.MAPPER.playlistDTOToPlaylist(playlistDTO);
		playlistRepository.save(playlist);
		return PlaylistMapper.MAPPER.playlistToPlaylistDTO(playlist);
	}

	@Override
	public boolean deletePlaylistInfo(String listName) {
		Playlist playlist = playlistRepository.findByName(listName);
		if(playlist != null) {
			playlistRepository.delete(playlist);
		}else {
			throw new RecordNotFoundException("Record Not Found");
		}
		return true;
	}

}
