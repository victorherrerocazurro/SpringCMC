package com.ejemplo.contenedor.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejemplo.contenedor.Contenedor;
import com.ejemplo.contenedor.logica.Negocio;

/**
 * Servlet implementation class OtroServlet
 */
@WebServlet("/OtroServlet")
public class OtroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OtroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Contenedor contenedor = (Contenedor) getServletContext().getAttribute(WebApplicationListener.CONTEXTO_SPRING_CHINO);
		
		Negocio negocio = (Negocio) contenedor.getBean("negocio");
		
		negocio.metodoNegocio();		
		
	}

}
