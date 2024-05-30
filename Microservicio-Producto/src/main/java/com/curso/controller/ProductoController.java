package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Producto;
import com.curso.service.ProductosService;


@RestController
public class ProductoController {

	@Autowired
	ProductosService service;
	
	@GetMapping(value="productos", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Producto> listaProductos(){
		return service.listaProductos();
	}
	
	@PutMapping(value="productos/{cod_producto}/{ud_compradas}")
	void actualizarStock (@PathVariable int cod_producto,@PathVariable int ud_compradas) {
		service.actualizarStock(cod_producto, ud_compradas);
	}
	
	@GetMapping(value = "productos/precioUnitario/{cod_producto}", produces = MediaType.APPLICATION_JSON_VALUE)
	double precioUnitario (@PathVariable int cod_producto) {
		return service.precioUnitario(cod_producto);
	}
}
