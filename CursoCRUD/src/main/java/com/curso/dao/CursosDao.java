package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.curso.model.Curso;

/**
 * Interfaz que extiende de JpaRepository.
 * @author Kevin
 */
public interface CursosDao extends JpaRepository<Curso, Integer> {

	/**
	 * Método que busca los cursos comprendidos entre los parametros
	 * @param precio1
	 * @param precio2
	 * @return lista de Cursos.
	 */
	@Query("SELECT c FROM Curso c WHERE c.precio BETWEEN :precio1 AND :precio2")
	List<Curso> buscarEntrePrecio(@Param("precio1") double precio1,@Param("precio2") double precio2);
}
