package com.curso.service;

import java.util.List;

import com.curso.model.Pedido;

public interface PedidosService {

	void insertarPedido(Pedido pedido);
	
	List<Pedido> listaPedidos();
}
