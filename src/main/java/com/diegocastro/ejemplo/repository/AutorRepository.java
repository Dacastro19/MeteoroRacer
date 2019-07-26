package com.diegocastro.ejemplo.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.diegocastro.ejemplo.entity.Autores;

public interface AutorRepository extends Repository<Autores, Integer>{
	
	List<Autores> findAll();
	Autores findOne(int id);
	Autores save(Autores a);
	void delete(Autores a);
	
}
