package com.crudcursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudcursos.model.Curso;
import com.crudcursos.service.CursosService;

@CrossOrigin("*")
@RestController
public class CursosController {

	@Autowired
	CursosService service;
	
	@Value("${eureka.instance.instance-id}")
	private String instancia;

	/**
	 * Lista de cursos
	 * 
	 * @return JSON con la lista de cursos existentes
	 */
	@GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Curso> cursos() {
		System.out.println(instancia);
		return service.cursos();
	}

	/**
	 * Dará de alta un curso
	 * 
	 * @param curso JSON con los datos del curso
	 * @return lista con los cursos existentes
	 */
	@PostMapping(value = "curso", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	List<Curso> altaCurso(@RequestBody Curso curso) {
		return service.altaCurso(curso);
	}

	/**
	 * Eliminará un curso
	 * 
	 * @param codCurso código del curso
	 * @return lista con los cursos existentes
	 */
	@DeleteMapping(value = "curso/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Curso> eliminarCurso(@PathVariable("codCurso") String codCurso) {
		return service.eliminarCurso(codCurso);
	}

	/**
	 * Actualización de la duración de un curso
	 * 
	 * @param codCurso código del curso
	 * @param duracion número de horas
	 */
	@PutMapping(value = "curso/{codCurso}/{duracion}")
	void actualizarDuracionCurso(@PathVariable("codCurso") String codCurso,
			@PathVariable("duracion") Integer duracion) {
		service.actualizarDuracionCurso(codCurso, duracion);
	}

	/**
	 * Busca un curso a partir del código
	 * 
	 * @param codCurso código del curso
	 * @return datos del curso
	 */
	@GetMapping(value = "curso/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	Curso buscarCurso(@PathVariable("codCurso") String codCurso) {
		return service.buscarCurso(codCurso);
	}
	
	@GetMapping(value = "curso/nombre/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	Curso buscarCursoPorNombre(@PathVariable("nombre") String nombre) {
		return service.buscarCursoPorNombre(nombre);
	}

	/**
	 * Busca todos los cursos que se encuentren en un rango de precios
	 * 
	 * @param precioMinimo
	 * @param precioMaximo
	 * @return cursos que se encuentren en dicho rango de precios
	 */
	@GetMapping(value = "curso/{precioMinimo}/{precioMaximo}", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Curso> buscarCursosPorPrecio(@PathVariable("precioMinimo") Double precioMinimo,
			@PathVariable("precioMaximo") Double precioMaximo) {
		return service.buscarCursosPorPrecio(precioMinimo, precioMaximo);

	}

}
