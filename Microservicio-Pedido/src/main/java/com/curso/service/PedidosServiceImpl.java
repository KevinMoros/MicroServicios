package com.curso.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.dao.PedidosDao;
import com.curso.model.Pedido;
import com.curso.model.Producto;

@Service
public class PedidosServiceImpl implements PedidosService {

	@Autowired
	PedidosDao dao;

	@Autowired
	RestTemplate template;

	private final String URL = "http://localhost:8000/";

	@Override
	public void insertarPedido(Pedido pedido) {

		List<Producto> productos = Arrays.asList(template.getForObject(URL + "productos", Producto[].class));
		Producto producto = null;

		boolean existe = false;

		for (Producto producto2 : productos) {
			if (producto2.getCod_producto() == pedido.getCod_producto()) {
				existe = true;
				producto = producto2;
			}
		}
		if (existe) {

			template.put(URL + "productos/" + producto.getCod_producto() + "/" + pedido.getCantidad(), null);
			pedido.setNombre(producto.getNombre());
			pedido.setFecha_pedido(LocalDate.now());
			pedido.setPrecio(producto.getPrecio() * pedido.getCantidad());
			System.out.println(pedido.toString());
			dao.save(pedido);
		}
	}

	@Override
	public List<Pedido> listaPedidos() {
		return dao.findAll();
	}

}
