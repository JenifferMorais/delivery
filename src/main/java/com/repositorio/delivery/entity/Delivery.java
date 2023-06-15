package com.repositorio.delivery.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "DELIVERY")
public class Delivery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "STAGE")
	private String stage;
	
	@OneToOne
	@JoinColumn(name = "FK_ORDER", nullable = false)
	private Order order;
	
	@Column(name = "TERM")
	private Date term;
	
	public Delivery() {
		super();
	}


}
