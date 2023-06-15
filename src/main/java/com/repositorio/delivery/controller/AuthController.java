package com.repositorio.delivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repositorio.delivery.dto.AuthDTO;
import com.repositorio.delivery.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("auth")
public class AuthController {
	@Autowired
	UserService service;
	
	@PostMapping
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Error in request"),
			@ApiResponse(code = 403, message = "Access denied"),
			@ApiResponse(code = 404, message = "The user does not exist"),
			@ApiResponse(code = 500, message = "Invalid JWT Token") })
	@ApiOperation(value = "authenticate user")
	public String auth(@RequestBody AuthDTO auth) {
		return service.auth(auth.getUsername(), auth.getPassword());
	}
}
