package com.formaciones.service;

import java.util.List;

import com.formaciones.model.Formacion;


public interface FormacionesService {
	
	List<Formacion> cursos();
	
	void nuevoCurso(Formacion formacion);

}
