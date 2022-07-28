package com.quipux.spotify.api.service;

import javax.servlet.http.HttpSession;

public interface SpotifyAccessTokenService {
	public String getTokenSimple(HttpSession session);
}
