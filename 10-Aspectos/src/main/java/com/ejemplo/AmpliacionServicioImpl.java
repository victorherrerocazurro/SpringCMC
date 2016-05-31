package com.ejemplo;

import java.util.Collection;

public class AmpliacionServicioImpl implements AmpliacionServicio {
	public Collection<Persona> getNoAfines(Persona persona){
		System.out.println("Ejecutando la ampliacion del servicio: GetNoAfines con la persona: " + persona);
		return null;
	}
}
