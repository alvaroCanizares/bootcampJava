package es.curso.controlador;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import es.curso.entidad.Videojuego;
import es.curso.negocio.GestorVideojuegos;

@RestController
public class ControladorVideoJuego {

	@Autowired
	GestorVideojuegos gestor;
	@Autowired
	private RestTemplate restTemplate;

//	2- Listado
//	3- Listado por nombre y por compañia
//	4- Que te proporcione el precio de todos los videojuegos que esten dados
//	de alta. Que nos devuelva un json con los precios de los videojuegos y 
//	la suma total de todos los videojuegos.


	@PostMapping(path="videojuegos",consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> altaVideojuego(@RequestBody Videojuego v) {
		System.out.println("altaVideojuego: objeto Videojuego: " + v);
		gestor.alta(v);
		return new ResponseEntity<Videojuego>(v,HttpStatus.CREATED);//201 CREATED
	}
	
	@GetMapping(path="obtener/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<Videojuego> getVideojuego(@PathVariable("id") int id) {
		System.out.println("Buscando juego con id: " + id);
	
		Videojuego v = gestor.obtener(id);
		if(v != null) {
			return new ResponseEntity<Videojuego>(v,HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
	
	@PutMapping(path="videojuego/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Videojuego> modificarVideojuego(
			@PathVariable("id") int id, 
			@RequestBody Videojuego v) {
		System.out.println("ID a modificar: " + id);
		System.out.println("Datos a modificar: " + v);
		v.setId(id);
		Videojuego pUpdate = gestor.modificar(v);
		if(pUpdate != null) {
			return new ResponseEntity<Videojuego>(HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
	
	@DeleteMapping(path="videojuego/{id}")
	public ResponseEntity<Videojuego> borrarVideojuego(@PathVariable int id) {
		System.out.println("ID a borrar: " + id);
		Videojuego v = gestor.baja(id);
		if(v != null) {
			return new ResponseEntity<Videojuego>(v,HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<Videojuego>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
	@GetMapping(path="/listar",produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List <Videojuego>> listar() {
		List <Videojuego> lista = gestor.listar();
		if(lista != null) {
			return new ResponseEntity<List <Videojuego>>(lista,HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<List <Videojuego>>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	}
	@GetMapping(path="/listarNombre",produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<Videojuego>> listarNombre(@RequestParam("nombre") String nombre,
			@RequestParam("compania") String compania) {
		
		List <Videojuego> lista = gestor.listarNombre(nombre,compania);
		
		if(lista != null) {
			return new ResponseEntity<List <Videojuego>>(lista,HttpStatus.OK);//200 OK
		}else {
			return new ResponseEntity<List <Videojuego>>(HttpStatus.NOT_FOUND);//404 NOT FOUND
		}
	
		
	}
}
