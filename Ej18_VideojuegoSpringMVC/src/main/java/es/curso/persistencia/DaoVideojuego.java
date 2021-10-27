package es.curso.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.curso.entidad.Videojuego;


public class DaoVideojuego {
	static List<Videojuego> listaVideojuegos = new ArrayList<Videojuego>();
	static Videojuego v1 = new Videojuego(1, "Solitario", "Microsoft", 10, "Bill Gates", "www.google.es");
	static Videojuego v2 = new Videojuego(2, "Solitario", "Microsoft", 10, "Bill Gates", "www.google.es");
	static Videojuego v3 = new Videojuego(3, "Solitario", "Microsoft", 10, "Bill Gates", "www.google.es");
	static Videojuego v4 = new Videojuego(4, "Solitario", "Microsoft", 10, "Bill Gates", "www.google.es");
	static Videojuego v5 = new Videojuego(5, "Solitario", "Microsoft", 10, "Bill Gates", "www.google.es");
	
	static{
	listaVideojuegos.add(v1);
	listaVideojuegos.add(v2);
	listaVideojuegos.add(v3);
	listaVideojuegos.add(v4);
	listaVideojuegos.add(v5);	
	}
	
	
	public List<Videojuego> listar() {
		return listaVideojuegos;
	}

	public Videojuego obtener(int id) {
		Videojuego vAux = null;
		
		for (Videojuego videojuego : listaVideojuegos) {
			if(videojuego.getId() == id) {
				vAux = videojuego;
			}
		}
		return vAux;
	}

}
