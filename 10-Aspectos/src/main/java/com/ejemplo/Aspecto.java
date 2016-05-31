package com.ejemplo;

import org.aspectj.lang.ProceedingJoinPoint;

public class Aspecto {
	public void antesDeServicio(Persona p){
		System.out.println("Se va a proceder a ejecutar el servicio con la persona: " + p);
		
		p.setEdad(40);
		
	}
	
	public void despuesDeServicio(Persona p) {
		System.out.println("Se ha terminado de ejecutar el servicio con la persona: " + p);
	}
	
	public void durante(ProceedingJoinPoint joinPoint, Persona p){
		long inicio = System.currentTimeMillis();
		System.out.println("Antes de ejecutar el servicio con la persona " + p);
		p.setEdad(123);
		try {
			joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		long duracion = System.currentTimeMillis() - inicio;
		System.out.println("Despues de ejecutar el servicio, habiendo durado la operación: " + duracion + " con la persona " + p);
	}
}
