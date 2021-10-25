package es.curso.modelo.persistencia;

import es.curso.modelo.entidades.Cliente;

public interface DaoCliente {
	int insertar(Cliente c);
	int modificar(Cliente c);
	int borrar(int id);
	Cliente buscar(int id);
	Cliente buscar(String nombre);
	
}
