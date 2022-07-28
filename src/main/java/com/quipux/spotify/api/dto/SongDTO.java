package com.quipux.spotify.api.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@Getter
	private int id;
	
	
	@NotEmpty
	@Getter
	private String title;
	
	@NotEmpty
	@Getter
	private String artist;
	
	@NotEmpty
	@Getter
	private String album;
	
	@Getter
	private String year;
	
	@Getter
	private List<CategoryDTO> category;
	
}
