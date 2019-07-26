 package com.diegocastro.ejemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegocastro.ejemplo.entity.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Integer>{

	Usuarios findByNombre(String nombre);
}
