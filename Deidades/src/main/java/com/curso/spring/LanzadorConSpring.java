package com.curso.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LanzadorConSpring {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		Dios dios = context.getBean(Dios.class);
		Dios yavee = context.getBean(Dios.class);
		
		if(dios.equals(yavee)){
			System.out.println("Todos los dioses son el mismo");
		}
		
		Persona adan = (Persona) context.getBean("adan");
		
		System.out.println(adan);
		
		Persona eva = (Persona) context.getBean("eva");
		
		System.out.println(eva);
		
		adan = (Persona) context.getBean("adan");
		
		System.out.println(adan);
		
		context.destroy();

	}

}
