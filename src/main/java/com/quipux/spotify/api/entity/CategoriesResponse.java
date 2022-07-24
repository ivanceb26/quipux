package com.quipux.spotify.api.entity;

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
public class CategoriesResponse {
	
	@Getter
	@ManyToMany(cascade = CascadeType.MERGE)
	Categories categories;
}
