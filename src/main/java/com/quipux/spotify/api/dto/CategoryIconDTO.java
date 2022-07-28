package com.quipux.spotify.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryIconDTO {
	
	@Getter
	private String height;
	
	@Getter
	private String url;
	
	@Getter
	private String width;

}
