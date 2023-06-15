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

import com.repositorio.delivery.entity.Order;
import com.repositorio.delivery.repository.OrderRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderRepository repository;

	@GetMapping
	@ApiOperation(value = "Returns all orders", authorizations = { @Authorization(value = "apiKey") })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Error in request"),
			@ApiResponse(code = 403, message = "Access denied"),
			@ApiResponse(code = 404, message = "No order found"),
			@ApiResponse(code = 500, message = "Invalid JWT Token") })
	public List<Order> findAll() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "PathParam is the order id ", notes = "Returns the searched order", authorizations = {
			@Authorization(value = "apiKey") })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Error in request"),
			@ApiResponse(code = 403, message = "Access denied"),
			@ApiResponse(code = 404, message = "The order does not exist"),
			@ApiResponse(code = 500, message = "Invalid JWT Token") })
	public Order findById(@PathVariable("id") Integer id) throws NotFoundException {
		return repository.findById(id).orElseThrow(NotFoundException::new);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete the order for id", authorizations = { @Authorization(value = "apiKey") })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Error in request"),
			@ApiResponse(code = 403, message = "Access denied"),
			@ApiResponse(code = 404, message = "The order does not exist"),
			@ApiResponse(code = 500, message = "Invalid JWT Token") })
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}

	@PostMapping
	@ApiOperation(value = "Save order", authorizations = { @Authorization(value = "apiKey") })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Error in request"),
			@ApiResponse(code = 403, message = "Access denied"),
			@ApiResponse(code = 404, message = "The order does not exist"),
			@ApiResponse(code = 500, message = "Invalid JWT Token") })
	public Integer save(@RequestBody Order order) {
		return repository.save(order).getId();
	}
}
