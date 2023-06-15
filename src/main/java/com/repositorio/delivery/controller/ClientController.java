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

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientRepository repository;

	@GetMapping
	public List<Client> findAll() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Client findById(@PathVariable("id") Integer id) throws NotFoundException {
		return repository.findById(id).orElseThrow(NotFoundException::new);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}

	@PostMapping
	public Integer save(@RequestBody Client client) {
		return repository.save(client).getId();
	}

}
