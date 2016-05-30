package com.curso.spring;

public class Lanzador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dios elUnicoDios = Dios.getInstance();
		
		Dios otroDios = Dios.getInstance();
		
		if (elUnicoDios.equals(otroDios)){
			System.out.println("Todos los dioses son el mismo");
		}
		
		Persona adan = elUnicoDios.crearPersona();
		
		adan.setNombre("adan");
		
		Direccion direccion = new Direccion();
		
		direccion.setCalle("Mayor");
		
		adan.setDireccion(direccion);
		
		System.out.println(adan);
	}

}
