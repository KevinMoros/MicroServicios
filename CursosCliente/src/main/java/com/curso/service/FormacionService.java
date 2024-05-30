package com.curso.service;

import java.util.List;

import com.curso.modelo.Formacion;

public interface FormacionService {
	
	List<Formacion> cursosExistentes();
	
	void nuevoCurso(Formacion formacion);

}
