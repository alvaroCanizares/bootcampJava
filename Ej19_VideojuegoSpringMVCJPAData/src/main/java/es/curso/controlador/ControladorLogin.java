package es.curso.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import es.curso.entidad.Usuario;
import es.curso.entidad.Videojuego;
import es.curso.negocio.GestorUsuario;
import es.curso.negocio.GestorVideojuegos;


@Controller
@SessionScope
public class ControladorLogin {
	

	@Autowired
	private GestorVideojuegos gestorVideojuegos;
	@Autowired
	private GestorUsuario gestorUsuario;
	
	private  List<Videojuego> listaVideojuegos;
	//Es llamado desde index.html y devuelve el nombre del jsp a cargar
	@RequestMapping("formulario")
	public String verFormulario() {
		return "formulario";
	}
	
	@RequestMapping("nuevoUsuario")
	public String nuevoUsuario() {
		return "nuevoUsuario";
	}
	
	@RequestMapping("altaJuego")
	public String altaJuego() {
		return "altaJuego";
	}
	
	@RequestMapping("modificarJuego")
	public String modificarJuego() {
		return "modificarJuego";
	}
	
	@RequestMapping("bajaJuego")
	public String bajaJuego() {
		return "bajaJuego";
	}
	
	//Recibe usuario y nombre de formulario.jsp
	@RequestMapping(path="login",method=RequestMethod.POST)
	public ModelAndView metodoFormulario(@RequestParam("usuario")String usuario,
			@RequestParam("contrasenia") String contrasenia,
			ModelAndView mav) throws Exception {
		try {
			Usuario uAux = gestorUsuario.obtener(usuario);
			if(uAux.getUsuario().contentEquals(usuario) && uAux.getContrasenia().contentEquals(contrasenia)) {
				//exito
				actualizarLista();
				mav.addObject("lista", listaVideojuegos);
				mav.setViewName("listadoVideoJuegos");
				
			}else {//fallo
				
				mav.setViewName("errorLogin");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e);
			mav.setViewName("usuarioNoExiste");
		}
		
		
		
		return mav;
		
	}

	private void actualizarLista() {
		listaVideojuegos = gestorVideojuegos.listar();
	}
	
	@RequestMapping(path="detalleJuego", method=RequestMethod.POST)
	public ModelAndView detalleJuego(@RequestParam("id") int id,
			ModelAndView mav) {
		
			Videojuego vAux = gestorVideojuegos.obtener(id);
			if(vAux !=null) {
				mav.addObject("v",vAux);
				mav.setViewName("detalleVideojuego");
				
			}else {
				mav.setViewName("errorVideojuego");
			}
		return mav;
	}
	@RequestMapping(path="doNuevoUsuario",method=RequestMethod.POST)
	public ModelAndView crearNuevoUsuario(@RequestParam("usuario")String usuario,
			@RequestParam("contrasenia") String contrasenia,
			ModelAndView mav) throws ServletException, IOException {
			Usuario u = new Usuario(usuario,contrasenia);
		try {
			gestorUsuario.alta(u);
			
		}catch (Exception e) {
			System.err.println(e);
		}
		mav.setViewName("formulario");
		return mav;
		
	}
	
	@RequestMapping(path="doAltaJuego",method=RequestMethod.POST)
	public ModelAndView crearNuevoJuego(@RequestParam("id")int id,
			@RequestParam("nombre") String nombre,
			@RequestParam("compania") String compania,
			@RequestParam("creador") String creador,
			@RequestParam("link") String link,
			@RequestParam("notaMedia") double notaMedia,
			ModelAndView mav) throws ServletException, IOException {
			Videojuego v = new Videojuego(id, nombre, compania, notaMedia, creador, link);
		try {
			gestorVideojuegos.alta(v);
			
		}catch (Exception e) {
			System.err.println(e);
		}
		actualizarLista();
		mav.addObject("lista", listaVideojuegos);
		mav.setViewName("listadoVideoJuegos");
		return mav;
		
	}
	@RequestMapping(path="doModificarJuego",method=RequestMethod.POST)
	public ModelAndView ModificarJuego(@RequestParam("id")int id,
			@RequestParam("nombre") String nombre,
			@RequestParam("compania") String compania,
			@RequestParam("creador") String creador,
			@RequestParam("link") String link,
			@RequestParam("notaMedia") double notaMedia,
			ModelAndView mav) throws ServletException, IOException {
			Videojuego v = new Videojuego(id, nombre, compania, notaMedia, creador, link);
		try {
			gestorVideojuegos.modificar(v);
			
		}catch (Exception e) {
			System.err.println(e);
		}
		actualizarLista();
		mav.addObject("lista", listaVideojuegos);
		mav.setViewName("listadoVideoJuegos");
		return mav;
		
	}
	
	@RequestMapping(path="doBajaJuego",method=RequestMethod.POST)
	public ModelAndView bajaJuego(@RequestParam("id")int id,
			ModelAndView mav) throws ServletException, IOException {
		try {
			gestorVideojuegos.baja(id);
			
		}catch (Exception e) {
			System.err.println(e);
		}
		actualizarLista();
		mav.addObject("lista", listaVideojuegos);
		mav.setViewName("listadoVideoJuegos");
		return mav;
		
	}
	
}
