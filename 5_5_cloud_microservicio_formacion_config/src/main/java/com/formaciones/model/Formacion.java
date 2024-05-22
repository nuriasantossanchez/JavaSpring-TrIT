package com.formaciones.model;

public class Formacion {

	String curso;
	Integer asignaturas;
	Double precio;
	
	public Formacion() {
		super();
	}

	public Formacion(String curso, Integer asignaturas, Double precio) {
		super();
		this.curso = curso;
		this.asignaturas = asignaturas;
		this.precio = precio;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Integer getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Integer asignaturas) {
		this.asignaturas = asignaturas;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	

}
