package es.curso.negocio;

import java.util.List;

import org.springframework.stereotype.Component;

import es.curso.entidad.Videojuego;
import es.curso.persistencia.DaoVideojuego;

@Component

public class GestorVideojuegos {
	
	private DaoVideojuego daoVideojuego;
	
	public List<Videojuego> listar() {
		daoVideojuego = new DaoVideojuego();
		return daoVideojuego.listar();
	}
	
	public Videojuego obtener (int id) {
		daoVideojuego = new DaoVideojuego();
		return daoVideojuego.obtener(id);
	}

}
