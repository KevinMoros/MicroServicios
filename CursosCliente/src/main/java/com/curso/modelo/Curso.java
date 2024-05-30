package com.curso.modelo;

import java.util.Objects;


/**
 * Clase que representa un Curso.
 * @author Kevin
 *
 */
public class Curso {

	private int codCurso;
	private String nombre;
	private int duracion;
	private double precio;

	public Curso() {
		super();
	}

	public Curso(int codCurso) {
		super();
		this.codCurso = codCurso;
	}
	

	public Curso(int codCurso, String nombre, int duracion, double precio) {
		super();
		this.codCurso = codCurso;
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}
	
	public Curso(String nombre, int duracion, double precio) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codCurso, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return codCurso == other.codCurso && Objects.equals(nombre, other.nombre);
	}

}
