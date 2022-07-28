package com.quipux.spotify.api.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.quipux.spotify.api.dto.CategoriesDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
	
	@Getter
	private String href;
	
	@Getter
	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "category_icons", 
      joinColumns = @JoinColumn(name = "icon_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
	List<CategoryIcon> icons;
	
	@Getter
	@Id
	private String id;
	
	@Getter
	private String name;
	
	@Getter
	@ManyToMany(mappedBy = "category")
    private List<Song> songs;
	

}