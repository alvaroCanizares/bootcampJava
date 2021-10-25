package es.curso.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import es.curso.entidad.Coche;
import es.curso.persistencia.interfaces.DaoCoche;

@Repository
public class DaoCocheJPA implements DaoCoche{
	@PersistenceContext
	private EntityManager em;
	
	
	public boolean alta(Coche c) {
		em.persist(c);
		return true;
	}

	
	public boolean baja(String matricula) {
		Coche cAux = em.find(Coche.class, matricula);
		em.remove(cAux);
		return true;
	}

	
	public boolean modificar(Coche c) {
		em.merge(c);
		return true;
	}


	public Coche obtener(String matricula) {
		return em.find(Coche.class, matricula);
	}

	
	public List<Coche> listar() {
		@SuppressWarnings("unchecked")
		List<Coche> coches = em.createQuery("from Coche c").getResultList();
		return coches;
	}

}
