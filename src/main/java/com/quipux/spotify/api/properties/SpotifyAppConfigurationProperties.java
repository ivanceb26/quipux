package com.quipux.spotify.api.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "com.quipux.spotify.api")
public class SpotifyAppConfigurationProperties {

	private App app = new App();

	@Data
	public class App {
		private String clientId = "fba3cfd993544c1bb0614485c0fc30ca";
		private String redirectUrl = "http://localhost:8080/spotify/callback";
		private String scope = "playlist-read-collaborative playlist-modify-public playlist-read-private playlist-modify-private user-read-private user-read-email";
		private String clientSecret = "6647abf57bf64da0b164910e65b1a131";
		private String scopeAll = "ugc-image-upload,user-read-playback-state,user-modify-playback-state,user-read-currently-playing,"
				+ "streaming,app-remote-control,user-read-email,user-read-private,playlist-read-collaborative,playlist-modify-public,"
				+ "playlist-read-private,playlist-modify-private,user-library-modify,user-library-read,user-top-read,"
				+ "user-read-playback-position,user-read-recently-played,user-follow-read,user-follow-modify";
	}
}