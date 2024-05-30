package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;
import com.curso.service.CursosService;

/**
 * Clase controladora del Curso.
 * @author Kevin
 *
 */
@RestController
public class CursosController {

	/**
	 * Instancia de la interfaz CursosService
	 */
	@Autowired
	CursosService service;
	
	/**
	 * Método que inserta un curso pasando los datos por el cuerpo de la peticion.
	 * @param curso
	 * @return lista con los cursos existentes.
	 */
	@PostMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
	List<Curso> insertarCurso(@RequestBody Curso curso){
		return service.insertarCurso(curso);
	}
	
	/**
	 * Metodo que elimina un curso pasando su codCurso por la url.
	 * @param codCurso
	 * @return lista con los cursos existentes.
	 */
	@DeleteMapping(value = "cursos/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Curso> eliminarCurso(@PathVariable int codCurso){
		return service.eliminarCurso(codCurso);
	}
	
	/**
	 * Método que actualiza un curso.
	 * @param codCurso representa el curso que se quiere buscar.
	 * @param duracion representa el dato que se quiere actualizar del curso buscado.
	 */
	@PutMapping(value = "cursos")
	void actualizarDuracionCurso(@RequestParam("codCurso") int codCurso,@RequestParam("duracion") int duracion) {
		service.actualizarDuracionCurso(codCurso, duracion);
	}
	
	/**
	 * Método que busca un curso.
	 * @param codCurso representa el id del curso que se quiere buscar.
	 * @return un curso.
	 */
	@GetMapping(value = "cursos/{codCurso}", produces = MediaType.APPLICATION_JSON_VALUE)
	Curso buscarCurso(@PathVariable int codCurso) {
		return service.buscarCurso(codCurso);
	}
	
	/**
	 * Método que busca cursos comprendidos entre los parametros.
	 * @param precio1
	 * @param precio2
	 * @return lista de los cursos comprendidos entre los parametros.
	 */
	@GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Curso> buscarEntrePrecio(@RequestParam("precio1") double precio1,@RequestParam("precio2") double precio2){
		return service.buscarEntrePrecio(precio1, precio2);
	}
	
	@GetMapping(value = "cursos/lista", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Curso> listaCursos(){
		return service.listarCursos();
	}
	
}
