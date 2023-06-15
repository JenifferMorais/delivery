package com.repositorio.delivery.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.repositorio.delivery.controller.UserController;
import com.repositorio.delivery.entity.AppUser;
import com.repositorio.delivery.repository.UserRepository;

public class UserServiceTest {

	@Mock
	UserRepository repository;

	@InjectMocks
	UserController controller;

//	@Test
//	void listar() {
//		Mockito.lenient().when(repository.findAll()).thenReturn(new ArrayList<Usuario>(){{add(new Usuario(1, "jeniffer.morais", "12345"));}});
//		List<Usuario> result = controller.listar();
//		for (Usuario usuario : result) {
//			System.out.println(usuario);
//		}
//		assert(!result.isEmpty());
//	}

	/*
	 * @Test void buscarPorId() { Usuario usuario = new Usuario(); usuario.setId(1);
	 * 
	 * Mockito.lenient().when(repository.findById(usuario.getId())).thenReturn(
	 * Optional.of(usuario)); Usuario result =
	 * controller.buscarPorId(usuario.getId()); System.out.println(result);
	 * 
	 * }
	 */
}
