package com.quipux.spotify.api.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SONG")
public class Song {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	@Setter
	private int id;
	
	@Column(nullable = false) 
	@Getter
	@Setter
	private String title;
	
	@Column(nullable = false) 
	@Getter
	@Setter
	private String artist;
	
	@Column(nullable = false) 
	@Getter
	@Setter
	private String album;
	
	@Column(nullable = false) 
	@Getter
	@Setter
	private String year;
	
	@Column(nullable = false) 
	@Getter
	@Setter
	private String category;
	
	@Getter
	@Setter
	@ManyToMany(mappedBy = "songs")
    private List<Playlist> playlists;

	
}
