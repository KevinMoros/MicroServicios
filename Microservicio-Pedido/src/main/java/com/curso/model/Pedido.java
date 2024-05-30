package com.curso.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod_pedido;
	private LocalDate fecha_pedido;
	private int cod_producto;
	private String nombre;
	private int cantidad;
	private double precio;

	public Pedido() {
		super();
	}

	public Pedido(int cod_pedido) {
		super();
		this.cod_pedido = cod_pedido;
	}

	public Pedido(LocalDate fecha_pedido, String nombre, int cantidad, double precio) {
		super();
		this.fecha_pedido = fecha_pedido;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public Pedido(LocalDate fecha_pedido, int cod_producto, String nombre, int cantidad, double precio) {
		super();
		this.fecha_pedido = fecha_pedido;
		this.cod_producto = cod_producto;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	public Pedido(int cod_producto, int cantidad) {
		super();
		this.cod_producto = cod_producto;
		this.cantidad = cantidad;
	}

	public int getCod_pedido() {
		return cod_pedido;
	}

	public void setCod_pedido(int cod_pedido) {
		this.cod_pedido = cod_pedido;
	}

	public LocalDate getFecha_pedido() {
		return fecha_pedido;
	}

	public void setFecha_pedido(LocalDate fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod_pedido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return cod_pedido == other.cod_pedido;
	}

	@Override
	public String toString() {
		return "Pedido [cod_pedido=" + cod_pedido + ", fecha_pedido=" + fecha_pedido + ", cod_producto=" + cod_producto
				+ ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}

	
}
