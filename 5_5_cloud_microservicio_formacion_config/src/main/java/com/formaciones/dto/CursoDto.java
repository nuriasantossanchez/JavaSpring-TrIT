package com.formaciones.dto;

public class CursoDto {

	String codCurso;
	String nombre;
	Integer duracion;
	Integer asignaturas;
	Double precio;

	public CursoDto() {
		super();
	}

	public CursoDto(String codCurso, String nombre, Integer duracion, Integer asignaturas, Double precio) {
		super();
		this.codCurso = codCurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.asignaturas = asignaturas;
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
		return this.duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Integer getAsignaturas() {
		return this.duracion < 50 ? 5 : 10;
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
