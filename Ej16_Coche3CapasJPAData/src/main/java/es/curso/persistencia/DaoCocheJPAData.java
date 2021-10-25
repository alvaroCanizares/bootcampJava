package es.curso.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.curso.entidad.Coche;

@Repository
public interface DaoCocheJPAData extends JpaRepository<Coche, String>{
//	@PersistenceContext
//	private EntityManager em;
//	

	
//	public boolean alta(Coche c) {
//		em.persist(c);
//		return true;
//	}
//
//	
//	public boolean baja(String matricula) {
//		Coche cAux = em.find(Coche.class, matricula);
//		em.remove(cAux);
//		return true;
//	}
//
//	
//	public boolean modificar(Coche c) {
//		em.merge(c);
//		return true;
//	}
//
//
//	public Coche obtener(String matricula) {
//		return em.find(Coche.class, matricula);
//	}
//
//	
//	public List<Coche> listar() {
//		@SuppressWarnings("unchecked")
//		List<Coche> coches = em.createQuery("from Coche c").getResultList();
//		return coches;
//	}

}
