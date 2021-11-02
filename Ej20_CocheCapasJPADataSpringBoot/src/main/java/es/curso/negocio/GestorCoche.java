package es.curso.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.curso.entidad.Coche;
import es.curso.persistencia.DaoCocheJPAData;


	
@Service
public class GestorCoche {
	public GestorCoche() {}
	
	@Autowired
	private DaoCocheJPAData cocheDao;
	
	@Transactional
	public String alta(Coche c){
		if(c.getMatricula().length() == 7
				&& c.getMarca()!= null
				&& c.getModelo()!=null) {
			System.out.println(c);
			Coche cAux = cocheDao.save(c);
			return cAux.getMatricula();
		}
		return "";
	}
	
	@Transactional
	public String modificar(Coche c) {
		if(c.getMatricula().length() == 7
				&& c.getMarca()!= null
				&& c.getModelo()!=null) {
			System.out.println(c);
			Coche cAux = cocheDao.save(c);
			return cAux.getMatricula();
		}
		return "";
	}
	
	@Transactional
	public String baja (String matricula) {
		cocheDao.deleteById(matricula);
		return matricula;
	}
	
	public Coche obtener(String matricula) {
		Coche c = cocheDao.getById(matricula);
		return c;
	}
	 public List<Coche> listar(){
		 List <Coche> lista = cocheDao.findAll();
		 return lista;
	 }

}
