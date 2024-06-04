package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.ProductosDao;
import com.curso.model.Producto;

import jakarta.transaction.Transactional;

@Service
public class ProductosServiceImpl implements ProductosService {
	
	@Autowired
	ProductosDao dao;

	@Override
	public List<Producto> listaProductos() {
		return dao.findAll();
	}

	@Transactional
	@Override
	public void actualizarStock(int cod_producto, int ud_compradas) {
		Producto producto = dao.findById(cod_producto).orElse(null);
		producto.setStock(producto.getStock() - ud_compradas);
		dao.save(producto);

	}

	@Transactional
	@Override
	public double precioUnitario(int cod_producto) {
		Producto producto = dao.findById(cod_producto).orElse(null);
		double precioUnitario = producto.getPrecio()/producto.getUnidad();
		
		return precioUnitario;
	}

}
