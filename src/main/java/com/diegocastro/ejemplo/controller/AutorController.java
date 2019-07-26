package com.diegocastro.ejemplo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diegocastro.ejemplo.entity.Autores;
import com.diegocastro.ejemplo.service.AutorService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/v1")
public class AutorController {

	@Autowired
	AutorService service;
	
	@RequestMapping(value = "/autor", method = RequestMethod.GET)
	public List<Autores> Listar() {
		return service.findAll();
	}
} 
