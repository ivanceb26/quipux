package com.quipux.spotify.api.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Categories {
	
	@Getter
	private String href;
	
	@Getter
	@ManyToMany(cascade = CascadeType.MERGE)
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
	
	@Getter
	@ManyToMany(mappedBy = "categories")
	private List<CategoriesResponse> categoriesResponse;
}
