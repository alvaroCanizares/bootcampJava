package es.curso.modelo.persistencia;

import java.util.ArrayList;

import es.curso.modelo.entidades.Pedido;

public interface DaoPedido {
	int insertar(Pedido p);
	ArrayList<Pedido> listar(int id);

	
}
