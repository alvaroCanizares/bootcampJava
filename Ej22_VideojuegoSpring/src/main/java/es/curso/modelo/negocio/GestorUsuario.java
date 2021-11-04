package es.curso.modelo.negocio;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.modelo.entidad.Usuario;
import es.curso.modelo.persistencia.DaoUsuario;

@Service
public class GestorUsuario {
	
	@Autowired
	private DaoUsuario daoUsuario;
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public String insertar(Usuario u) {
		if(!u.getUser().equals("") && !u.getPwd().equals("")) {
			daoUsuario.save(u);
			return u.getUser();
		}
		return "No se ha añadido el usuario";
	}

}
