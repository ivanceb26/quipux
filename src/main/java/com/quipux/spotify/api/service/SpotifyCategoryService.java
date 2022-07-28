package com.quipux.spotify.api.service;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

import com.quipux.spotify.api.dto.CategoriesResponseDTO;

public interface SpotifyCategoryService {
	
	public ResponseEntity<CategoriesResponseDTO> getCategories(HttpSession session);
}
