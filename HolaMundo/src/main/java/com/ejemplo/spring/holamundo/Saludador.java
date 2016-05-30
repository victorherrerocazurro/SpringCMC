package com.ejemplo.spring.holamundo;

public class Saludador {

	private String nombre;
	private String apellido;

	public Saludador(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido=apellido;
	}
	
	
	
	public void saludar() {
		System.out.println("Hola " + nombre + " " + apellido + "!!!!");
	}
	
}
