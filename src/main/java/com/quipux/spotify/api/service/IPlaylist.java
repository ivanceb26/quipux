package com.quipux.spotify.api.service;

import java.util.List;

import com.quipux.spotify.api.dto.PlaylistDTO;
import com.quipux.spotify.api.entity.Playlist;
import com.quipux.spotify.api.repository.PlaylistRepository;

public interface IPlaylist {
	public String getPlaylistInfo();

	public List<PlaylistDTO> getPlaylists();

	public PlaylistDTO getPlaylistByQuery(String listName);

	public PlaylistDTO createPlaylistInfo(PlaylistDTO playlistDTO);

	public boolean deletePlaylistInfo(String listName);
	
}
