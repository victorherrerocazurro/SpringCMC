package com.ejemplo.contenedor.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejemplo.contenedor.Contenedor;
import com.ejemplo.contenedor.logica.Negocio;

/**
 * Servlet implementation class MiAccion
 */

//http://localhost:8080/ContenedorWeb/MiAccion

@WebServlet("/MiAccion")
public class MiAccion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MiAccion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Aqui quiero el contexto/contedor SpringChino
		
		ServletContext contextoWeb = getServletContext();
		
		Contenedor contenedor = (Contenedor) contextoWeb.getAttribute(WebApplicationListener.CONTEXTO_SPRING_CHINO);
		
		Negocio negocio = (Negocio) contenedor.getBean("negocio");
		
		negocio.metodoNegocio();
		
	}

}
