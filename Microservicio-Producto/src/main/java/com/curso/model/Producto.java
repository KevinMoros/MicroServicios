package com.curso.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_producto;
	private String nombre;
	private String descripcion;
	private int stock;
	private int unidad;
	private double precio;

	public Producto() {
		super();
	}

	public Producto(int cod_producto) {
		super();
		this.cod_producto = cod_producto;
	}

	public Producto(String nombre, String descripcion, int stock, int unidad, double precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.unidad = unidad;
		this.precio = precio;
	}

	public Producto(int cod_producto, String nombre, String descripcion, int stock, int unidad, double precio) {
		super();
		this.cod_producto = cod_producto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.stock = stock;
		this.unidad = unidad;
		this.precio = precio;
	}

	public int getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(int cod_producto) {
		this.cod_producto = cod_producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getUnidad() {
		return unidad;
	}

	public void setUnidad(int unidad) {
		this.unidad = unidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod_producto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return cod_producto == other.cod_producto;
	}

}
