package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.CursosDao;
import com.curso.model.Curso;

import jakarta.transaction.Transactional;

/**
 * Clase que extiende de CursosService.
 * Implementa todos sus métodos.
 * @author Kevin
 */
@Service
public class CursoServiceImpl implements CursosService {

	@Autowired
	CursosDao dao;

	@Override
	public List<Curso> insertarCurso(Curso curso) {
		dao.save(curso);
		return dao.findAll();
	}

	@Override
	public List<Curso> eliminarCurso(int codCurso) {
		dao.deleteById(codCurso);
		return dao.findAll();
	}

	@Transactional
	@Override
	public void actualizarDuracionCurso(int codCurso, int duracion) {
		Curso curso = dao.findById(codCurso).orElse(null);
		curso.setDuracion(duracion);
	}

	@Override
	public Curso buscarCurso(int codCurso) {
		return dao.findById(codCurso).orElse(null);
	}

	@Override
	public List<Curso> buscarEntrePrecio(double precio1, double precio2) {
		return dao.buscarEntrePrecio(precio1, precio2);
	}

	@Override
	public List<Curso> listarCursos() {
		return dao.findAll();
	}

}
