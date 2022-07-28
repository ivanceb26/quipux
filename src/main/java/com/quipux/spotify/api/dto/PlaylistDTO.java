package com.quipux.spotify.api.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	private int id;
	
	@NotEmpty
	@Getter
	private String name;
	
	@NotEmpty
	@Getter
	private String description;
	
	@Getter
	private List<SongDTO> songs;
	
}
