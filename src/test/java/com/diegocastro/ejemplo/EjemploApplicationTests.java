package com.diegocastro.ejemplo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.diegocastro.ejemplo.entity.Usuarios;
import com.diegocastro.ejemplo.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EjemploApplicationTests {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	public void crearUsuarioTest() {
		Usuarios us = new Usuarios();
		us.setId(2);
		us.setNombre("bobesponja");
		us.setPassword(encoder.encode("gatito"));
		Usuarios retorno = repository.save(us);
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
	}

}
