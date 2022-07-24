package com.quipux.spotify.api.service;

import java.util.List;

import com.quipux.spotify.api.dto.PlaylistDTO;

public interface IPlaylist {

	public List<PlaylistDTO> getPlaylists();

	public PlaylistDTO getPlaylistByQuery(String listName);

	public PlaylistDTO createPlaylistInfo(PlaylistDTO playlistDTO);

	public boolean deletePlaylistInfo(String listName);
	
}
