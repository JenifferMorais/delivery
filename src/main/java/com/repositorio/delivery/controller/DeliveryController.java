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

import com.repositorio.delivery.entity.Delivery;
import com.repositorio.delivery.repository.DeliveryRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
	@Autowired
	DeliveryRepository repository;

	@GetMapping
	@ApiOperation(value = "Returns every deliveries", authorizations = { @Authorization(value = "apiKey") })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Error in request"),
			@ApiResponse(code = 403, message = "Access denied"),
			@ApiResponse(code = 404, message = "No delivery found"),
			@ApiResponse(code = 500, message = "Invalid JWT Token") })
	public List<Delivery> findAll() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "PathParam is the user id ", notes = "Returns the searched delivery", authorizations = {
			@Authorization(value = "apiKey") })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Error in request"),
			@ApiResponse(code = 403, message = "Access denied"),
			@ApiResponse(code = 404, message = "The delivery does not exist"),
			@ApiResponse(code = 500, message = "Invalid JWT Token") })
	public Delivery findById(@PathVariable("id") Integer id) throws NotFoundException {
		return repository.findById(id).orElseThrow(NotFoundException::new);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete the delivery for id", authorizations = { @Authorization(value = "apiKey") })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Error in request"),
			@ApiResponse(code = 403, message = "Access denied"),
			@ApiResponse(code = 404, message = "The delivery does not exist"),
			@ApiResponse(code = 500, message = "Invalid JWT Token") })
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}
	
	@PostMapping
	@ApiOperation(value = "Save delivery", authorizations = { @Authorization(value = "apiKey") })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Error in request"),
			@ApiResponse(code = 403, message = "Access denied"),
			@ApiResponse(code = 404, message = "The delivery does not exist"),
			@ApiResponse(code = 500, message = "Invalid JWT Token") })
	public Integer save(@RequestBody Delivery delivery) {
		return repository.save(delivery).getId();
	}

}
