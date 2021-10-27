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
import org.springframework.web.servlet.ModelAndView;

import es.curso.entidad.Videojuego;
import es.curso.negocio.GestorVideojuegos;


@Controller
public class ControladorLogin {
	
	final String USUARIO = "usuario";
	final String CONTRASENIA = "contrasenia";

	@Autowired
	private GestorVideojuegos gestor;
	
	//Es llamado desde index.html y devuelve el nombre del jsp a cargar
	@RequestMapping("formulario")
	public String verFormulario() {
		return "formulario";
	}
	
	//Recibe usuario y nombre de formulario.jsp
	@RequestMapping(path="login",method=RequestMethod.POST)
	public ModelAndView metodoFormulario(@RequestParam("usuario")String usuario,
			@RequestParam("contrasenia") String contrasenia,
			ModelAndView mav) throws ServletException, IOException {
		
		if(USUARIO.contentEquals(usuario) && CONTRASENIA.contentEquals(contrasenia)) {
			//exito
			List<Videojuego> listaVideojuegos = gestor.listar();
			mav.addObject("lista", listaVideojuegos);
			mav.setViewName("listadoVideoJuegos");
			
		}else {//fallo
			mav.setViewName("errorLogin");
		}
		return mav;
		
	}
	
	@RequestMapping(path="detalleJuego", method=RequestMethod.POST)
	public ModelAndView detalleJuego(@RequestParam("id") int id,
			ModelAndView mav) {
		
			Videojuego vAux = gestor.obtener(id);
			if(vAux !=null) {
				mav.addObject("v",vAux);
				mav.setViewName("detalleVideojuego");
				
			}else {
				mav.setViewName("errorVideojuego");
			}
		return mav;
	}
}
