package com.formaciones.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Formacion {

	String codCurso;
	@JsonAlias({ "curso" })
	String nombre;
	@JsonAlias({ "asignaturas" })
	Integer duracion;
	@JsonProperty("precio")
	Double precio;

	public Formacion(String codCurso, String nombre, Integer duracion, Double precio) {
		super();
		this.codCurso = codCurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}

	public String getCodCurso() {
		return codCurso != null ? codCurso
				: nombre.trim().substring(0, 3).toUpperCase().concat(this.duracion.toString());
	}

	public String getNombre() {
		return nombre.trim();
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = this.duracion != null ? duracion : duracion * 10;
	}

	public Integer getAsignaturas() {
		return duracion != null ? duracion/10 : duracion < 50 ? 5 : 10;
	}

}
