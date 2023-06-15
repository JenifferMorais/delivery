package com.repositorio.delivery.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repositorio.delivery.dto.AuthDTO;
import com.repositorio.delivery.service.UserService;

@RestController
@RequestMapping("auth")
public class AuthController {
	UserService service;
	
	@PostMapping
	public String auth(@RequestBody AuthDTO auth) {
		return service.auth(auth.getUsername(), auth.getPassword());
	}
}
