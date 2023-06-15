package com.repositorio.delivery.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repositorio.delivery.dto.UserDTO;
import com.repositorio.delivery.entity.AppUser;
import com.repositorio.delivery.repository.UserRepository;
import com.repositorio.delivery.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserRepository repository;
	@Autowired
	UserService service;

	@GetMapping
	@ApiOperation(value = "Returns all users", authorizations = { @Authorization(value = "apiKey") })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Error in request"),
			@ApiResponse(code = 403, message = "Access denied"),
			@ApiResponse(code = 404, message = "The user does not exist"),
			@ApiResponse(code = 500, message = "Invalid JWT Token") })
	public List<UserDTO> findAll() {
		return repository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "PathParam is the user id ", notes = "Returns the searched user", authorizations = {
			@Authorization(value = "apiKey") })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Error in request"),
			@ApiResponse(code = 403, message = "Access denied"),
			@ApiResponse(code = 404, message = "The user does not exist"),
			@ApiResponse(code = 500, message = "Invalid JWT Token") })
	public UserDTO findById(@PathVariable("id") Integer id) throws NotFoundException {
		return repository.findById(id).map(UserDTO::new).orElseThrow(NotFoundException::new);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete the user for id", authorizations = { @Authorization(value = "apiKey") })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Error in request"),
			@ApiResponse(code = 403, message = "Access denied"),
			@ApiResponse(code = 404, message = "The user does not exist"),
			@ApiResponse(code = 500, message = "Invalid JWT Token") })
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}

	@PostMapping
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Error in request"),
			@ApiResponse(code = 403, message = "Access denied"),
			@ApiResponse(code = 404, message = "The user does not exist"),
			@ApiResponse(code = 500, message = "Invalid JWT Token") })
	@ApiOperation(value = "Save user")
	public Integer save(@RequestBody AppUser user) {
		user.setPassword(service.encript(user.getPassword()));
		return repository.save(user).getId();
	}

}
