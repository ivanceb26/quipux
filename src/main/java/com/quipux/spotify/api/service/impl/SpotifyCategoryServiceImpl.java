package com.quipux.spotify.api.service.impl;

import java.util.Base64;

import javax.servlet.http.HttpSession;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.quipux.spotify.api.dto.AccessTokenDTO;
import com.quipux.spotify.api.dto.CategoriesResponseDTO;
import com.quipux.spotify.api.properties.SpotifyAppConfigurationProperties;
import com.quipux.spotify.api.service.SpotifyCategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@EnableConfigurationProperties(value = SpotifyAppConfigurationProperties.class)
public class SpotifyCategoryServiceImpl {

	private final RestTemplate restTemplate;
	private final SpotifyAppConfigurationProperties spotifyAppConfigurationProperties;
	private static final String URL = "https://api.spotify.com/v1/browse/categories";
	
	public ResponseEntity<String> getCategories(HttpSession session) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth((String) session.getAttribute("spotify_token"));
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("country", "CO");
		map.add("locale", "es_CO");
		map.add("limit", "10");
		map.add("offset", "1");
		

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
		String urlWithParams = URL+"?"+"country=CO&locale=es_CO&limit=10&offset=1";
		
		

		//HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		return restTemplate.exchange(URL, HttpMethod.GET, request, String.class);
		//return restTemplate.getForEntity(urlWithParams, String.class);
	}

}
