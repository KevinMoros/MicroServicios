package com.curso.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.modelo.Curso;
import com.curso.modelo.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService {

	@Autowired
	RestTemplate template;

	private String url = "http://localhost:8080/";

	@Override
	public List<Formacion> cursosExistentes() {
		List<Curso> cursos = Arrays.asList(template.getForObject(url + "cursos/lista", Curso[].class));
		List<Formacion> formaciones = new ArrayList<>();

		for (Curso curso : cursos) {
			Formacion formacion = new Formacion();
			formacion.setCurso(curso.getNombre());
			if (curso.getDuracion() >= 50) {
				formacion.setAsignaturas(10);
			} else {
				formacion.setAsignaturas(5);
			}
			formacion.setPrecio(curso.getPrecio());

			formaciones.add(formacion);
		}

		return formaciones;
	}

	@Override
	public void nuevoCurso(Formacion formacion) {
		List<Curso> cursos = Arrays.asList(template.getForObject(url + "cursos/lista", Curso[].class));
		
		boolean existe = false;

		Curso cursoInsertar = new Curso(
				formacion.getCurso(),
				formacion.getAsignaturas() * 10,
				formacion.getPrecio());

		for (Curso curso : cursos) {
			if(curso.getNombre().equalsIgnoreCase(cursoInsertar.getNombre())) {
				existe = true;
			}
		}
		
		if(!existe) {
			template.postForLocation(url+"cursos", cursoInsertar);
		}
	}
}
