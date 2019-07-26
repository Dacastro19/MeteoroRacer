package com.diegocastro.ejemplo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "autores")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Autores implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public Autores() {
		super();
	}
	
	public Autores(int id, String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}

	public String getApellido() {return apellido;}
	public void setApellido(String apellido) {this.apellido = apellido;}

}
