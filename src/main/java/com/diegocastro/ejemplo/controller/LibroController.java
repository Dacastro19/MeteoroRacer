package com.diegocastro.ejemplo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diegocastro.ejemplo.entity.Libros;
import com.diegocastro.ejemplo.service.LibroService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/v1")
public class LibroController {
	
	@Autowired
	LibroService service;
	
	@RequestMapping(value = "/libro", method = RequestMethod.GET)
	public List<Libros> Listar() {
		return service.findAll();
	}

}
