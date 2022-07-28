package com.quipux.spotify.api.service.impl;

import java.util.Base64;

import javax.servlet.http.HttpSession;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.quipux.spotify.api.dto.AccessTokenDTO;
import com.quipux.spotify.api.properties.SpotifyAppConfigurationProperties;
import com.quipux.spotify.api.service.SpotifyAccessTokenService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@EnableConfigurationProperties(value = SpotifyAppConfigurationProperties.class)
public class SpotifyAccessTokenServiceImpl implements SpotifyAccessTokenService{

	private final RestTemplate restTemplate;
	private final SpotifyAppConfigurationProperties spotifyAppConfigurationProperties;
	private static final String URL = "https://accounts.spotify.com/api/token";
	
	public String getTokenSimple(HttpSession session) {
		final var properties = spotifyAppConfigurationProperties.getApp();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setBasicAuth(Base64.getEncoder().encodeToString((""+properties.getClientId()+ ':' +properties.getClientSecret()).getBytes()));
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("grant_type", "client_credentials");

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

		ResponseEntity<AccessTokenDTO> response = restTemplate.postForEntity(URL, request, AccessTokenDTO.class);
		session.setAttribute("spotify_token", (String) response.getBody().getAccess_token());
		return (String) session.getAttribute("spotify_token");
	}

}
