
package com.crudcursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudcursos.dao.CursosDao;
import com.crudcursos.model.Curso;

@Service
public class CursosServiceImp implements CursosService {

	@Autowired
	CursosDao dao;

	@Override
	public List<Curso> cursos() {
		return dao.findAll();
	}

	@Override
	public List<Curso> altaCurso(Curso curso) {
		dao.saveAndFlush(curso);
		return dao.findAll();
	}

	@Override
	public List<Curso> eliminarCurso(String codCurso) {
		dao.deleteById(codCurso);
		return dao.findAll();
	}

	@Override
	public void actualizarDuracionCurso(String codCurso, Integer duracion) {
		Curso curso = dao.findById(codCurso).orElse(null);
		if (curso != null) {
			curso.duracion = duracion != null && duracion > 0 ? duracion : curso.duracion;
			dao.save(curso);
		}
	}

	@Override
	public Curso buscarCurso(String codCurso) {
		return dao.findById(codCurso).orElse(null);
	}

	@Override
	public List<Curso> buscarCursosPorPrecio(Double precioMinimo, Double precioMaximo) {
		return dao.findByPrecioBetween(precioMinimo, precioMaximo);
	}

	@Override
	public Curso buscarCursoPorNombre(String nombre) {
		return dao.findByNombre(nombre);
	}

}
