package com.greatlearning.batch5Jwt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthenticationResponse {

	private final String jwt;
//	public AuthenticationResponse(String jwt)
//	{
//		this.jwt=jwt;
//	}
//	
//	public String getJwt()
//	{
//		return this.jwt;
//	}
}
