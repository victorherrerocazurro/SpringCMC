package com.curso.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.spring.entidades.Persona;
import com.curso.spring.negocio.ServicioBusquedaParejas;

public class Lanzador {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context 
			= new ClassPathXmlApplicationContext("ApplicationContext.xml"
					/*,"Persistencia.xml"*/);

		ServicioBusquedaParejas servicioBusquedaParejas 
			= context.getBean(ServicioBusquedaParejas.class);
		
		servicioBusquedaParejas.buscarAfines(new Persona());
		
	}

}
