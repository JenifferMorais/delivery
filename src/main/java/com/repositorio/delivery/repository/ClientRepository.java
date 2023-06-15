package com.repositorio.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.repositorio.delivery.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
