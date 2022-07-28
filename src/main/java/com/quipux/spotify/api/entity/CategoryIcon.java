package com.quipux.spotify.api.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CategoryIcon {
	
	@Id
	@Getter
	private int id;
	
	@Getter
	private String height;
	
	@Getter
	private String url;
	
	@Getter
	private String width;
	
	@ManyToMany(mappedBy = "icons")
	private List<Category> categories;
}
