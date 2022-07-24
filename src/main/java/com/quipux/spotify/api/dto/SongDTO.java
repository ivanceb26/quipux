package com.quipux.spotify.api.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	private int id;
	
	@Getter
	private String title;
	
	@Getter
	private String artist;
	
	@Getter
	private String album;

	@Getter
	private String year;

	@Getter
	private String category;
	
}
