package es.curso.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.entidad.Videojuego;
import es.curso.negocio.GestorVideojuegos;


//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	final String USUARIO = "usuario";
	final String CONTRASENIA = "contrasenia";
	
	private static final long serialVersionUID = 1L;
    
	public LoginServlet() {
        super();
    }
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputUsuario = request.getParameter("usuario");
		String inputContrasenia = request.getParameter("contrasenia");
		
		if(USUARIO.contentEquals(inputUsuario) && CONTRASENIA.contentEquals(inputContrasenia)) {
			//exito
			GestorVideojuegos gestor = new GestorVideojuegos();
			List<Videojuego> listaVideojuegos = gestor.listar();
			
			request.setAttribute("lista", listaVideojuegos);
			request.getRequestDispatcher("listadoVideoJuegos.jsp").forward(request, response);
		}else {//fallo
			request.getRequestDispatcher("errorLogin.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
