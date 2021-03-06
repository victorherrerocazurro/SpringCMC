package com.aeat.portalparejas.test;

import java.util.Collection;
import java.util.Locale;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aeat.portalparejas.modelo.entidades.Persona;
import com.aeat.portalparejas.modelo.servicios.ServicioParejas;

public class PortalParejasTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml", "classpath:persistencia.xml");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuracion.class);
		
		ServicioParejas servicio = context.getBean(ServicioParejas.class);
		
		//Inicializamos la BD
		
		Persona persona = new Persona("Luis",27,1.82f,'H');
		Persona persona2 = new Persona("Marcelo",45,1.78f,'H');
		Persona persona3 = new Persona("Angela",35,1.75f,'M'); //Ideal de Luis
		Persona persona4 = new Persona("Maria",45,1.78f,'M'); //Afin de Luis por altura
		Persona persona5 = new Persona("Carmen",25,1.68f,'M'); //Afin de Luis por edad
		
		servicio.insert(persona);
		servicio.insert(persona2);
		servicio.insert(persona3);
		servicio.insert(persona4);
		servicio.insert(persona5);
		
		//Consultamos al servicio
		
		Persona ideal = servicio.getIdeal(persona);
		System.out.println(context.getMessage("mensaje.ideal", new Object[]{persona.getNombre(), (ideal!=null)?ideal.getNombre():null}, Locale.US));
		
		Collection<Persona> afines = servicio.getAfines(persona);
		System.out.println(context.getMessage("mensaje.afin", new Object[]{persona.getNombre()}, Locale.US));
		
		for (Persona afin : afines) {
			System.out.println(afin.getNombre());
		}
		
		//Limpiamos los datos
		
		servicio.borrar(persona);
		servicio.borrar(persona2);
		servicio.borrar(persona3);
		servicio.borrar(persona4);
		servicio.borrar(persona5);
		
	}

}
