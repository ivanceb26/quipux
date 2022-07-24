package com.quipux.spotify.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpotifyapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotifyapiApplication.class, args);
		log.info("Start Application");
	}
	
}
