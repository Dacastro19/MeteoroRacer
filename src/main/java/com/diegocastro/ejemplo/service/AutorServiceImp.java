package com.diegocastro.ejemplo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegocastro.ejemplo.entity.Autores;
import com.diegocastro.ejemplo.repository.AutorRepository;

@Service
public class AutorServiceImp implements AutorService{

	@Autowired
	private AutorRepository repository;
	
	@Override
	public List<Autores> findAll() {

		return repository.findAll();
	}

	@Override
	public Autores findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autores add(Autores a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autores update(Autores a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Autores delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
