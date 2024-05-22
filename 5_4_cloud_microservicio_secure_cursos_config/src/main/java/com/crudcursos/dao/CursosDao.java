package com.crudcursos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudcursos.model.Curso;

public interface CursosDao extends JpaRepository<Curso, String> {

	List<Curso> findByPrecioBetween(Double precioMinimo, Double precioMaximo);

	Curso findByNombre(String nombre);

}
