package com.ejemplo.contenedor.logica;

public class Negocio {

	//private Persistencia persistencia = new Persistencia();
	private IPersistencia persistencia = null;
	
	/*public Negocio() {
		super();
		// TODO Auto-generated constructor stub
	}*/

	public Negocio(IPersistencia persistencia) {
		super();
		this.persistencia = persistencia;
	}

	public void setPersistencia(IPersistencia persistencia) {
		this.persistencia = persistencia;
	}

	public void metodoNegocio() {
		System.out.println("Ejecutando la logica de negocio");
		persistencia.metodoPersistencia();
	}
	
}
