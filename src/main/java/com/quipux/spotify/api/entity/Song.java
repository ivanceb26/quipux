package com.quipux.spotify.api.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "SONG")
@NoArgsConstructor
@AllArgsConstructor
public class Song {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	private int id;
	
	@Column(nullable = false) 
	@Getter
	private String title;
	
	@Column(nullable = false) 
	@Getter
	private String artist;
	
	@Column(nullable = false) 
	@Getter
	private String album;
	
	@Column(nullable = false) 
	@Getter
	private String year;
	
	@Column(nullable = false) 
	@Getter
	private String category;
	
	@Getter
	@ManyToMany(mappedBy = "songs")
    private List<Playlist> playlists;

	
}
