package com.quipux.spotify.api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
	
	@Getter
	private String href;
	
	@Getter
	List<CategoryIconDTO> icons;
	
	@Getter
	private String id;
	
	@Getter
	private String name;

}