package com.quipux.spotify.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.quipux.spotify.api.converter.DtoToEntityConverter;
import com.quipux.spotify.api.converter.EntityToDtoConverter;
import com.quipux.spotify.api.converter.SourceTargetMapper;
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
		return playlistRepository.findAll().stream().map(entityToDtoConverter::mapperToPlaylistDTO).collect(Collectors.toList());
	}
	
	@Override
	public PlaylistDTO getPlaylistByQuery(String listName) {
		return null;
	}

	@Override
	public PlaylistDTO createPlaylistInfo(PlaylistDTO playlistDTO) {
		Playlist playlist = new Playlist();
		playlist.setDescription(playlistDTO.getDescription());
		playlist.setName(playlistDTO.getName());
		
		List<SongDTO> songsDTO = playlistDTO.getSongs();
		if(!songsDTO.isEmpty()) {
			playlist.setSongs(songsDTO.stream().map(dtoToEntityConverter::mapperToSong).collect(Collectors.toList()));
		}
		
		//Playlist playlist = SourceTargetMapper.MAPPER.playlistDTOToPlaylist(playlistDTO);
		
		playlistRepository.save(playlist);
		
		return entityToDtoConverter.mapperToPlaylistDTO(playlist);
	}

	@Override
	public boolean deletePlaylistInfo(String listName) {
		Playlist playlist = playlistRepository.findByName(listName);
		if(playlist != null) {
			playlistRepository.delete(playlist);
		}
		return true;
	}

}
