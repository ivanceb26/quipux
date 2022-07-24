package com.quipux.spotify.api.entity;

import java.util.List;

import javax.persistence.CascadeType;
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
public class Category {
	
	@Getter
	private String href;
	
	@Getter
	@ManyToMany(cascade = CascadeType.MERGE)
	List<CategoryIcon> icons;
	
	@Getter
	@Id
	private String id;
	
	@Getter
	private String name;
	
	@Getter
	@ManyToMany(mappedBy = "items")
	private List<Categories> categories;

}