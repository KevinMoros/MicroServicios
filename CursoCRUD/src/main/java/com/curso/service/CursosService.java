package com.curso.service;

import java.util.List;

import com.curso.model.Curso;

/**
 * Interfaz que almacena los metodos a usar en la clase CursoServiceImpl.
 * @author Kevin
 */
public interface CursosService {

	List<Curso> insertarCurso(Curso curso);
	List<Curso> eliminarCurso(int codCurso);
	void actualizarDuracionCurso(int codCurso, int duracion);
	Curso buscarCurso(int codCurso);
	List<Curso> buscarEntrePrecio(double precio1, double precio2);
	List<Curso> listarCursos();
	
}
