package com.formaciones.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.formaciones.model.Formacion;

@Service
public class FormacionesServiceImpl implements FormacionesService {

	@Autowired
	RestClient restClient;

	private String url = "http://localhost:8081/";

	@Override
	public List<Formacion> cursos() {
		return Arrays.asList(restClient.get().uri(url + "cursos").accept(MediaType.APPLICATION_JSON).retrieve()
				.body(Formacion[].class));
	}

	@Override
	public void nuevoCurso(Formacion formacion) {
		Formacion formacionPorNombre = restClient.get().uri(url + "cursopornombre/" + formacion.getNombre())
				.accept(MediaType.APPLICATION_JSON).retrieve().body(Formacion.class);

		if (formacionPorNombre == null) {
			restClient.post().uri(url + "curso").body(formacion).accept(MediaType.APPLICATION_JSON).retrieve()
					.toBodilessEntity();
		}
	}

}
