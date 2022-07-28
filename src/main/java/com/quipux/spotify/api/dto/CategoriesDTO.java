package com.quipux.spotify.api.dto;

import java.util.List;

import com.quipux.spotify.api.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriesDTO {
	
	@Getter
	private String href;
	
	@Getter
	List<Category> items;
	
	@Getter
	private float limit;
	
	@Getter
	private String next;
	
	@Getter
	private float offset;
	
	@Getter
	private String previous;
	
	@Getter
	private float total;
}
