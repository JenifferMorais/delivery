package com.repositorio.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.repositorio.delivery.repository.UserRepository;
import com.repositorio.delivery.security.JwtTokenProvider;

@Service
public class UserService {
	@Autowired
	AuthenticationManager authentication;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	JwtTokenProvider jwtToken;
	@Autowired
	UserRepository repository;

	public String auth(String username, String password) {
		authentication.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		return jwtToken.createToken(username);
	}

	public String encript(String secretkey) {
		return passwordEncoder.encode(secretkey);
	}

}
