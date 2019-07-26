package com.diegocastro.ejemplo.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.diegocastro.ejemplo.entity.Libros;

public interface LibroRepository extends Repository<Libros, Integer>{

	List<Libros> findAll();
	Libros findOne(int id);
	Libros save(Libros l);
	void delete(Libros l);
	
}
