package com.repositorio.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.repositorio.delivery.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
