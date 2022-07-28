package com.quipux.spotify.api.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;

@Builder
@Entity
@Table(name = "PLAYLIST")
@NoArgsConstructor
@AllArgsConstructor
public class Playlist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	private int id;
	
	@Column(nullable = false, unique=true) 
	@Getter
	private String name;
	
	@Column(nullable = false)
	@Getter
	private String description;
	
	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "song_playlist", 
      joinColumns = @JoinColumn(name = "song_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "playlist_id", referencedColumnName = "id"))
	@Getter
    private List<Song> songs;

	
}
