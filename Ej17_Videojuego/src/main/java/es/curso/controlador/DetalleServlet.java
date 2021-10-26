package es.curso.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.curso.entidad.Videojuego;
import es.curso.persistencia.DaoVideojuego;

/**
 * Servlet implementation class DetalleServlet
 */
@WebServlet("/DetalleServlet")
public class DetalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		DaoVideojuego daoVideojuego = new DaoVideojuego();
		Videojuego v = daoVideojuego.obtener(Integer.parseInt(id));
		
		if(v != null) {
			request.setAttribute("v", v);
			request.getRequestDispatcher("detalleVideojuego.jsp").forward(request, response);
		}else {
		request.getRequestDispatcher("errorVideojuego.jsp").forward(request, response);	
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
