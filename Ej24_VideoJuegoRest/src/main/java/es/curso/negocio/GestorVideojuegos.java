package es.curso.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.curso.entidad.Videojuego;
import es.curso.persistencia.DaoVideojuego;

@Service
public class GestorVideojuegos {
	@Autowired
	private DaoVideojuego daoVideojuego;
	
	@Transactional
	public String alta(Videojuego v) {
		daoVideojuego.save(v);
		return v.getNombre();
	}
	
	@Transactional
	public Videojuego modificar(Videojuego v) {
		daoVideojuego.save(v);
		return daoVideojuego.findById(v.getId()).get();
	}
	
	@Transactional
	public Videojuego baja(int id) {
		daoVideojuego.deleteById(id);
		try {
			return obtener(id);
		}catch (Exception e) {
			return null;
		}
		
		
	}
	
	public List<Videojuego> listar() {
		List <Videojuego> lista = daoVideojuego.findAll();
		return lista;
	}
	
	public List<Videojuego> listarNombre(String nombre,String compania) {
		List <Videojuego> lista = daoVideojuego.findByNombreAndCompania(nombre, compania);
		
		return lista;
	}
	
	public Videojuego obtener (int id) {
		return daoVideojuego.findById(id).get();
	}

}
