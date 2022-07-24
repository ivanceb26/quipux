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

import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "PLAYLIST")
public class Playlist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	@Setter
	private int id;
	
	@Column(nullable = false) 
	@Getter
	@Setter
	private String name;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String description;
	
	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "song_playlist", 
      joinColumns = @JoinColumn(name = "song_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "playlist_id", referencedColumnName = "id"))
	@Getter
	@Setter
    private List<Song> songs;

	
}
