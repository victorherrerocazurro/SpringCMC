package com.ejemplo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lanzador {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"ApplicationContext.xml");
		INegocio bean = (INegocio) context.getBean("negocio");
		
		Persona persona = new Persona();
		persona.setNombre("Victor");
		persona.setEdad(12);
		
		bean.metodo(persona);
		
		System.out.println("Operacion despues de ejecutar el servicio");
		
		((AmpliacionServicio)bean).getNoAfines(persona);
	}
}
