package com.formaciones.service;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.formaciones.dto.CursoDto;
import com.formaciones.model.Formacion;

@Service
public class FormacionesServiceImpl implements FormacionesService {

	@Autowired
	private RestClient.Builder restClientBuilder;

	private String url = "http://servicio-cursos/";

	@Value("${app.user}")
	private String user;

	@Value("${app.pass}")
	private String pass;

	@Override
	public List<CursoDto> cursos() {
		return Arrays.asList(getFormaciones());
	}

	@Override
	public void nuevoCurso(Formacion formacion) {
		CursoDto cursoPorNombre = this.getFormacion(formacion);

		if (cursoPorNombre == null) {
			postFormacion(formacion);
		}
	}

	private CursoDto[] getFormaciones() {
		return restClientBuilder.build().get().uri(url + "cursos")
				.header("Authorization", "Basic " + getBase64(user, pass)).accept(MediaType.APPLICATION_JSON).retrieve()
				.body(CursoDto[].class);
	}

	private CursoDto getFormacion(Formacion formacion) {
		CursoDto cursoPorNombre = restClientBuilder.build().get().uri(url + "curso/nombre/" + formacion.getCurso())
				.header("Authorization", "Basic " + getBase64(user, pass)).accept(MediaType.APPLICATION_JSON).retrieve()
				.body(CursoDto.class);
		return cursoPorNombre;
	}

	private void postFormacion(Formacion formacion) {
		restClientBuilder.build().post().uri(url + "curso").body(toCursoDto(formacion))
				.header("Authorization", "Basic " + getBase64(user, pass)).accept(MediaType.APPLICATION_JSON).retrieve()
				.toBodilessEntity();
	}

	private CursoDto toCursoDto(Formacion formacion) {
		CursoDto cursoDto = new CursoDto();
		String strCodCurso = formacion.getCurso().trim().length() >= 3
				? formacion.getCurso().trim().substring(0, 3).toUpperCase()
				: formacion.getCurso().trim().toUpperCase();
		String codCurso = strCodCurso.concat(String.valueOf(formacion.getAsignaturas() * 10));
		cursoDto.setCodCurso(codCurso);
		cursoDto.setNombre(formacion.getCurso());
		cursoDto.setDuracion(formacion.getAsignaturas() * 10);
		cursoDto.setAsignaturas(formacion.getAsignaturas());
		cursoDto.setPrecio(formacion.getPrecio());
		return cursoDto;
	}

	private String getBase64(String user, String pass) {
		String authorization = user + ":" + pass;
		return Base64.getEncoder().encodeToString(authorization.getBytes());
	}

}
