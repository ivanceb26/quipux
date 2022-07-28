package com.quipux.spotify.api.controller;

import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quipux.spotify.api.service.impl.SpotifyAccessTokenServiceImpl;
import com.quipux.spotify.api.service.impl.SpotifyCategoryServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/spotify")
public class SpotifyController {
	
	private final SpotifyAccessTokenServiceImpl accessTokenService;
	private final SpotifyCategoryServiceImpl categoryService;

	@GetMapping(path = "/loginsimple", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Model> getTokenSimple(final Model model,HttpSession httpSession) {
		model.addAttribute("token", accessTokenService.getTokenSimple(httpSession));
		return new ResponseEntity<>(model,HttpStatus.OK);
	}
	
	@GetMapping(path = "/get-categories", produces = MediaType.APPLICATION_JSON)
	public ResponseEntity<Model> getCategories(final Model model,HttpSession httpSession) {
		model.addAttribute("token", categoryService.getCategories(httpSession));
		return new ResponseEntity<>(model,HttpStatus.OK);
	}
	
}
