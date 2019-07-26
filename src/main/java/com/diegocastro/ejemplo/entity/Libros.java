package com.diegocastro.ejemplo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "libros")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Libros implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public Libros() {
		super();
	}
	
	public Libros(int id, String nombre, Autores autor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
	}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_autor")
	private Autores autor;
	

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}

	public Autores getAutor() {return autor;}
	public void setAutor(Autores autor) {this.autor = autor;}
	
	
}
