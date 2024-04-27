package com.crudcursos.service;

import java.util.List;

import com.crudcursos.model.Curso;

public interface CursosService {

	List<Curso> cursos();

	List<Curso> altaCurso(Curso curso);

	List<Curso> eliminarCurso(String codCurso);

	void actualizarDuracionCurso(String codCurso, Integer duracion);

	Curso buscarCurso(String codCurso);

	List<Curso> buscarCursosPorPrecio(Double precioMinimo, Double precioMaximo);

}
