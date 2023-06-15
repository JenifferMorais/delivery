package com.repositorio.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repositorio.delivery.entity.Client;
import com.repositorio.delivery.repository.ClientRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientRepository repository;

	@GetMapping
	@ApiOperation(value = "Returns every customer", authorizations = { @Authorization(value = "apiKey") })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Error in request"),
			@ApiResponse(code = 403, message = "Access denied"),
			@ApiResponse(code = 404, message = "No customers were found"),
			@ApiResponse(code = 500, message = "Invalid JWT Token") })
	public List<Client> findAll() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "PathParam is the user id ", notes = "Returns the searched client", authorizations = {
			@Authorization(value = "apiKey") })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Error in request"),
			@ApiResponse(code = 403, message = "Access denied"),
			@ApiResponse(code = 404, message = "The client does not exist"),
			@ApiResponse(code = 500, message = "Invalid JWT Token") })
	public Client findById(@PathVariable("id") Integer id) throws NotFoundException {
		return repository.findById(id).orElseThrow(NotFoundException::new);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete the client for id", authorizations = { @Authorization(value = "apiKey") })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Error in request"),
			@ApiResponse(code = 403, message = "Access denied"),
			@ApiResponse(code = 404, message = "The client does not exist"),
			@ApiResponse(code = 500, message = "Invalid JWT Token") })
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}

	@PostMapping
	@ApiOperation(value = "Save client", authorizations = { @Authorization(value = "apiKey") })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Error in request"),
			@ApiResponse(code = 403, message = "Access denied"),
			@ApiResponse(code = 404, message = "The client does not exist"),
			@ApiResponse(code = 500, message = "Invalid JWT Token") })
	public Integer save(@RequestBody Client client) {
		return repository.save(client).getId();
	}

}
