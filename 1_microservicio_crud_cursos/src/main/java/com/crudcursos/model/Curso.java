package com.crudcursos.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="cursos")
public class Curso {

	@Id
	public String codCurso;
	public String nombre;
	public Integer duracion;
	public Double precio;
	
	
}
