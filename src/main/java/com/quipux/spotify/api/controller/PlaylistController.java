package com.quipux.spotify.api.controller;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quipux.spotify.api.dto.PlaylistDTO;
import com.quipux.spotify.api.service.IPlaylist;

@Produces({ "application/json" })
@RestController
@RequestMapping("/playlist")
public class PlaylistController {
	@Autowired
	private IPlaylist iPlaylist;

	@GetMapping(path = "/lists")
	public ResponseEntity<List<PlaylistDTO>> getPlaylists() {
		return new ResponseEntity<>(iPlaylist.getPlaylists(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/lists/{listName}")
	public ResponseEntity<PlaylistDTO> getPlaylistsByQuery(@PathVariable("listName") String listName) {	
		return new ResponseEntity<>(iPlaylist.getPlaylistByQuery(listName), HttpStatus.OK);
	}
	
	@PostMapping(path = "/lists", consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<PlaylistDTO> createPlaylist(@RequestBody PlaylistDTO playlistDTO) {
		return new ResponseEntity<>(iPlaylist.createPlaylistInfo(playlistDTO), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/lists/{listName}")
	public ResponseEntity<Boolean> deletePlaylist(@PathVariable("listName") String listName) {
		return new ResponseEntity<>(iPlaylist.deletePlaylistInfo(listName), HttpStatus.NO_CONTENT);
	}

}
