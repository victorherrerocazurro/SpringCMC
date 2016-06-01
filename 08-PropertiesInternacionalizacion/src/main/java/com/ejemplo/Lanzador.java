package com.ejemplo;

import java.util.Locale;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lanzador {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Persona bean = context.getBean(Persona.class);
		
		System.out.println(bean.getNombre());
		
		System.out.println(context.getMessage("lenguaje", null, Locale.getDefault()));
		
		System.out.println(context.getMessage("mensaje", new String[]{"Victor"}, Locale.getDefault()));
		
		System.out.println(context.getMessage("mensaje", new String[]{"Victor"}, Locale.ENGLISH));
	}

}
