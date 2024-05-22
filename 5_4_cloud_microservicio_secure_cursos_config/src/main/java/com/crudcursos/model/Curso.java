package com.crudcursos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {

	@Id
	String codCurso;
	String nombre;
	Integer duracion;
	Double precio;

	public Curso() {
		super();
	}

	public Curso(String codCurso, String nombre, Integer duracion, Double precio) {
		super();
		this.codCurso = codCurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}

	public String getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
