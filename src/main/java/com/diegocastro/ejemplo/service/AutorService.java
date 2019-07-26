package com.diegocastro.ejemplo.service;

import java.util.List;

import com.diegocastro.ejemplo.entity.Autores;

public interface AutorService {

	List<Autores> findAll();
	Autores findById(int id);
	Autores add(Autores a);
	Autores update(Autores a);
	Autores delete(int id);
	
}
