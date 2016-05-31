package com.ejemplo;

import java.util.Collection;

public class Proxy implements INegocio, AmpliacionServicio{
	private INegocio target;
	private AmpliacionServicio ampliacion;
		
	public Collection<Persona> getNoAfines(Persona persona) {
		System.out.println("Antes del servicio");
		Collection<Persona> resultado = ampliacion.getNoAfines(persona);
		System.out.println("Despues del servicio");
		return resultado;
	}
	
	public void metodo(Persona persona) {
		target.metodo(persona);
	}
}
