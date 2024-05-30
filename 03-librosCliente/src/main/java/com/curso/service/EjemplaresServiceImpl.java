package com.curso.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Ejemplar;

@Service
public class EjemplaresServiceImpl implements EjemplaresService {

	@Autowired
	RestTemplate template;

	private String url = "http://localhost:8080/";

	@Override
	public List<Ejemplar> nuevoEjemplar(Ejemplar ejemplar) {
		template.postForLocation(url + "libros", ejemplar); // http://localhost:8080/libros POST en 03-librosCRUD
		return Arrays.asList(template.getForObject(url + "libros", Ejemplar[].class)); // //http://localhost:8080/libros
																						// GET en 03-librosCRUD
	}

}