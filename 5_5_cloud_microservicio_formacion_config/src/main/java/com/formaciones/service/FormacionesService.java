package com.formaciones.service;

import java.util.List;

import com.formaciones.dto.CursoDto;
import com.formaciones.model.Formacion;


public interface FormacionesService {
	
	List<CursoDto> cursos();
	
	void nuevoCurso(Formacion formacion);

}
