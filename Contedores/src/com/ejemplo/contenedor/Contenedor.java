package com.ejemplo.contenedor;

import com.ejemplo.contenedor.logica.IPersistencia;
import com.ejemplo.contenedor.logica.Negocio;
import com.ejemplo.contenedor.logica.NuevaImplementacionPersistencia;

public class Contenedor {

	private NuevaImplementacionPersistencia persistencia;
	private Negocio negocio;

	//Quiero que el objeto este creado desde el principio,al contructor
	public Contenedor() {
		System.out.println("Creando el Bean Persistencia");
		persistencia = new NuevaImplementacionPersistencia();
		
		System.out.println("Creando el Bean Negocio");
		//Presentacion del Negocio con la Persistencia
		negocio = new Negocio(persistencia);
		
	}
	
	public Object getBean(String nombre){

		System.out.println("Obteniendo la referencia al Bean: " + nombre);
		switch (nombre) {
		case "persistencia":
			return persistencia;
		case "negocio":
			return negocio;
		default:
			return null;
		}
	}
	
}
