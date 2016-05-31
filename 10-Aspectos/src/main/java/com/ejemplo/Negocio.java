package com.ejemplo;

public class Negocio implements INegocio {
	/* (non-Javadoc)
	 * @see com.ejemplo.INegocio#metodo(com.ejemplo.Persona)
	 */
	public void metodo(Persona persona){
		System.out.println("negocio: " + persona);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
