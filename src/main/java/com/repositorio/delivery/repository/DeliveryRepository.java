package com.repositorio.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.repositorio.delivery.entity.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

}
