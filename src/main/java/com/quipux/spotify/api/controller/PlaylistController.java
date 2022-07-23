package com.quipux.spotify.api.controller;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quipux.spotify.api.converter.EntityToDtoConverter;
import com.quipux.spotify.api.dto.PlaylistDTO;
import com.quipux.spotify.api.entity.Playlist;
import com.quipux.spotify.api.service.IPlaylist;

@Produces({ "application/json" })
@RestController
@RequestMapping("/playlist")
public class PlaylistController {
	@Autowired
	private IPlaylist iPlaylist;
	
	@GetMapping(path = "/info")
	public String getPlaylistInfo() {
		String result = "";
		try {
			result = iPlaylist.getPlaylistInfo();
		} catch (Exception e) {
			System.out.println("ERROR:" + e);
		}
		return result;
	}
	
	@GetMapping(path = "/lists")
	public List<PlaylistDTO> getPlaylists() {
		List<PlaylistDTO> result = null;
		try {
			result = iPlaylist.getPlaylists();
		} catch (Exception e) {
			System.out.println("ERROR:" + e);
		}
		return result;
	}
	
	@GetMapping(path = "/lists/{listName}")
	public PlaylistDTO getPlaylistsByQuery(@PathVariable("listName") String listName) {	
		PlaylistDTO result = null;
		try {
			result = iPlaylist.getPlaylistByQuery(listName);
		} catch (Exception e) {
			System.out.println("ERROR:" + e);
		}
		return result;
	}
	
	@PostMapping(path = "/lists", consumes = MediaType.APPLICATION_JSON)
	public PlaylistDTO createPlaylist(@RequestBody PlaylistDTO playlistDTO) {
		PlaylistDTO result = null;
		try {
			result = iPlaylist.createPlaylistInfo(playlistDTO);
		} catch (Exception e) {
			System.out.println("ERROR:" + e);
		}
		return result;
	}
	
	@DeleteMapping(path = "/lists/{listName}")
	public void deletePlaylist(@PathVariable("listName") String listName) {
		try {
			iPlaylist.deletePlaylistInfo(listName);
		} catch (Exception e) {
			System.out.println("ERROR:" + e);
		}
	}

}
