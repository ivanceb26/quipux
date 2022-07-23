package com.quipux.spotify.api.dto;

import java.io.Serializable;
import java.util.List;

import com.quipux.spotify.api.entity.Song;

public class PlaylistDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int id;

	private String name;
	
	private String description;
	
	private List<SongDTO> songs;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<SongDTO> getSongs() {
		return songs;
	}

	public void setSongs(List<SongDTO> songs) {
		this.songs = songs;
	}
	
}
