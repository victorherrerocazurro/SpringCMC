package com.curso.spring;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ejemplo.spring.holamundo.Saludador;

/**
 * Servlet implementation class MiServlet
 */
public class MiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MiServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WebApplicationContext contenedorSpring = WebApplicationContextUtils
						.findWebApplicationContext(getServletContext());
		
		Saludador saludador = contenedorSpring.getBean(Saludador.class);
		
		saludador.saludar();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
