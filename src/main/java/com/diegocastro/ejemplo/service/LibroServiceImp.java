package com.diegocastro.ejemplo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegocastro.ejemplo.entity.Libros;
import com.diegocastro.ejemplo.repository.LibroRepository;

@Service
public class LibroServiceImp implements LibroService{
	
	@Autowired
	private LibroRepository repository;

	@Override
	public List<Libros> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Libros findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libros add(Libros l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libros update(Libros l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libros delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
