package com.quipux.spotify.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesResponseDTO {
	
	@Getter
	CategoriesDTO categories;
}
