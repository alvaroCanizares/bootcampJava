package jUnit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.runners.MethodSorters;

import entidad.Coche;
import negocio.GestorCoche;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteoDao {
	Coche cocheCorrecto = new Coche("0000001","nisan","cupra",39999);
	Coche cocheCorrecto2 = new Coche("0000002","nisan","cupra",39999);
	GestorCoche gestor = new GestorCoche();
	
	
//	@Test
//	public void alta() {
//		gestor.alta(cocheCorrecto);
//		Coche cocheRespuesta = gestor.obtener(cocheCorrecto.getMatricula());
//		assertEquals(cocheCorrecto, cocheRespuesta);
//	}
//	
//	@Test
//	public void baja() {
//		gestor.baja(cocheCorrecto.getMatricula());
//		Coche cocheRespuesta = gestor.obtener(cocheCorrecto.getMatricula());
//		assertNull(cocheRespuesta);
//	}
//	@Test
//	public void modificar() {
//		Coche cocheModificado = new Coche("0000002","****","****",0);
//		
//		gestor.alta(cocheCorrecto);
//		gestor.modificar(cocheModificado);
//		Coche cocheRespuesta = gestor.obtener(cocheCorrecto.getMatricula());
//		
//		assertEquals(cocheModificado, cocheRespuesta);
//	}
//
//	@Test
//	public void obtener() {
//		Coche cocheRespuesta = gestor.obtener(cocheCorrecto.getMatricula());
//		assertEquals(cocheCorrecto, cocheRespuesta);
//	}

	@Test
	public void AAlistar() {
		List <Coche> listaCoches = new ArrayList<Coche>();
		Coche c1 = new Coche("1234567","3","4",5);
		Coche c2 = new Coche("7777777","5","5",5);
		listaCoches.add(c1);
		listaCoches.add(c2);
		
		List <Coche> listaCochesRespuesta = gestor.listar();
		assertEquals(listaCoches, listaCochesRespuesta);
	}


}
