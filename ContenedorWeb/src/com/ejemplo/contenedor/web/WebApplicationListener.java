package com.ejemplo.contenedor.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ejemplo.contenedor.Contenedor;

/**
 * Application Lifecycle Listener implementation class WebApplicationListener
 *
 */
//@WebListener
public class WebApplicationListener implements ServletContextListener {

    public static final String CONTEXTO_SPRING_CHINO = "ContextoSpringChino";

	/**
     * Default constructor. 
     */
    public WebApplicationListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
        
    	System.out.println("Cargando el contexto de spring..........");
    	
    	//En este metodo creamos el contenedor
    	
    	//Este es el contexto web
    	ServletContext contextoWeb = arg0.getServletContext();
    	
    	Contenedor contextoSpringChino = new Contenedor();
    	
    	contextoWeb.setAttribute(CONTEXTO_SPRING_CHINO, contextoSpringChino);
    	
    }
	
}
