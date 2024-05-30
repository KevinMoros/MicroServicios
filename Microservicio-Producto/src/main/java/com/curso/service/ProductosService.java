package com.curso.service;

import java.util.List;

import com.curso.model.Producto;

public interface ProductosService {
	
	List<Producto> listaProductos();
	void actualizarStock (int cod_producto, int ud_compradas);
	double precioUnitario (int cod_producto);

}
