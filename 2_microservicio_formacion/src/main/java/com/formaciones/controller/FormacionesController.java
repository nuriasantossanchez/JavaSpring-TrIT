package com.formaciones.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.formaciones.model.Formacion;
import com.formaciones.service.FormacionesService;

@RestController
public class FormacionesController {

	@Autowired
	FormacionesService service;

	@GetMapping(value = "formacion")
	public List<Formacion> cursos() {
		return service.cursos();

	}

	@PostMapping(value = "formacion")
	public void altaCurso(@RequestBody Formacion formacion) {
		service.nuevoCurso(formacion);

	}

}
