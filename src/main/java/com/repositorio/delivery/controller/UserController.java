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

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserRepository repository;

	@GetMapping
	public List<UserDTO> findAll() {
		return repository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public UserDTO findById(@PathVariable("id") Integer id) throws NotFoundException {
		return repository.findById(id).map(UserDTO::new).orElseThrow(NotFoundException::new);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}
	
	@PostMapping
	public Integer save(@RequestBody AppUser usuario) {
		return repository.save(usuario).getId();
	}

}
