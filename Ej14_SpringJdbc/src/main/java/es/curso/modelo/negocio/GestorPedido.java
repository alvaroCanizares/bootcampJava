package es.curso.modelo.negocio;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.modelo.entidades.Pedido;
import es.curso.modelo.persistencia.DaoPedido;

@Service
public class GestorPedido {
	
	@Autowired
	DaoPedido daoPedido;
	
//	int insertar(Pedido p);
//	ArrayList<Pedido> listar(int id);
	
	public int insertar(Pedido p) {
		return daoPedido.insertar(p);
	}
	
	public ArrayList<Pedido> listar(int id){
		return daoPedido.listar(id);
	}
}
