package com.quipux.spotify.api.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class SongDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private int id;
	
	@Getter
	@Setter
	private String title;
	
	@Getter
	@Setter
	private String artist;
	
	@Getter
	@Setter
	private String album;

	@Getter
	@Setter
	private String year;

	@Getter
	@Setter
	private String category;
	
}
