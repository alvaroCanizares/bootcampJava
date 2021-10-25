package es.curso.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.curso.entidad.Coche;
import es.curso.persistencia.DaoCocheJPA;
import es.curso.persistencia.interfaces.DaoCoche;

@Service
public class GestorCoche {
	@Autowired
	private DaoCocheJPA cocheDao = new  DaoCocheJPA();
	
	@Transactional
	public boolean alta(Coche c){
		if(c.getMatricula().length() == 7
				&& c.getMarca()!= null
				&& c.getModelo()!=null) {
			System.out.println(c);
			boolean alta = cocheDao.alta(c);
			return alta;
		}
		return false;
	}
	
	@Transactional
	public boolean modificar(Coche c) {
		if(c.getMatricula().length() == 7
				&& c.getMarca()!= null
				&& c.getModelo()!=null) {

			boolean modif = cocheDao.modificar(c);
			return modif;
		}
		return false;
	}
	
	@Transactional
	public boolean baja (String matricula) {
		boolean baja = cocheDao.baja(matricula);
		return baja;
	}
	
	public Coche obtener(String matricula) {
		Coche c = cocheDao.obtener(matricula);
		return c;
	}
	 public List<Coche> listar(){
		 List <Coche> lista = cocheDao.listar();
		 return lista;
	 }

}
