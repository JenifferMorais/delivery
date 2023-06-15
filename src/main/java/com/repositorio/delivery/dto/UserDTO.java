package com.repositorio.delivery.dto;

import com.repositorio.delivery.entity.AppUser;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

	private Integer id;
	private String username;

	public UserDTO() {
		super();
	}
	
	public UserDTO(AppUser user) {
		super();
		this.id = user.getId();
		this.username = user.getUsername();
	}

	public UserDTO(Integer id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

}
