package com.repositorio.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.repositorio.delivery.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Integer> {

	AppUser findByUsername(String username);

}
