package com.curso.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Dios implements InitializingBean, DisposableBean {

	private static Dios instance = new Dios();
	
	private Dios() {
		// TODO Auto-generated constructor stub
	}
	
	public static Dios getInstance(){
		return instance;
	}
	
	public Persona crearPersona(){
		return new PersonaImpl();
	}
	
	//Ciclo de vida del Bean
	
	public void init(){
		System.out.println("INIT: creando a Dios");
	}
	
	public void miDestroy(){
		System.out.println("MIDESTROY: Destruyendo a Dios");
	}
	
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet: creando a Dios");
		
	}
	
	public void destroy() throws Exception {
		System.out.println("destroy: Destruyendo a Dios");
		
	}
	
	private class PersonaImpl implements Persona {
		
		private String nombrecito;
		private Direccion direccion;
		
		public String getNombre() {
			return nombrecito;
		}

		public void setNombre(String nombreeee) {
			this.nombrecito = nombreeee;
		}

		public Direccion getDireccion() {
			return direccion;
		}

		public void setDireccion(Direccion direccion) {
			this.direccion = direccion;
			
		}
		
	}
}
