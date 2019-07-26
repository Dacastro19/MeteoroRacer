package com.diegocastro.ejemplo.service;

import java.util.List;

import com.diegocastro.ejemplo.entity.Libros;


public interface LibroService {
	
	List<Libros> findAll();
	Libros findById(int id);
	Libros add(Libros l);
	Libros update(Libros l);
	Libros delete(int id);

}
