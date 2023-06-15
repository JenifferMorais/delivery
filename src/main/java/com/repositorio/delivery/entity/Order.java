package com.repositorio.delivery.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ORDERS")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "FK_CLIENT", nullable = false)
	private Client client;
	
	@Column(name = "CREATIONDATE")
	private Date creationDate;

	@Column(name = "DESCRIPTION")
	private String description;

}
