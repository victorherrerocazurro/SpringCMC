package com.ejemplo.spring.holamundo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lanzadora {

	public static void main(String[] args) {
		/*Saludador saludador = new Saludador();
		
		saludador.saludar();*/

		ClassPathXmlApplicationContext contendor = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		Saludador saludador = contendor.getBean(Saludador.class);
		
		saludador.saludar();
		
	}

}
