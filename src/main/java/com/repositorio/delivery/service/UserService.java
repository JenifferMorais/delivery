package com.repositorio.delivery.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.repositorio.delivery.repository.UserRepository;
import com.repositorio.delivery.security.JwtTokenProvider;

public class UserService {
	AuthenticationManager authentication;
	JwtTokenProvider jwtToken;
	UserRepository repository;
	
	public String auth(String username, String password) {
		authentication.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		return jwtToken.createToken(username, repository.findByUsername(username).getAppUserRoles());
	}

}
