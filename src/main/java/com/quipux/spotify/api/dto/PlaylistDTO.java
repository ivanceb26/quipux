package com.quipux.spotify.api.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class PlaylistDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private int id;

	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private String description;
	
	@Getter
	@Setter
	private List<SongDTO> songs;
	
}
