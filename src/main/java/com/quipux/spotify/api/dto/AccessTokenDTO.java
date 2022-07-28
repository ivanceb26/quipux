package com.quipux.spotify.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenDTO {

	@Getter
	private String access_token;
	
	@Getter
	private String token_type;
	
	@Getter
	private int expires_in;

}