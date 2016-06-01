package apps;

import java.util.ArrayList;
import java.util.Collection;

import javabeans.EnteSuperior;
import javabeans.Persona;
import javabeans.Tierra;

public class ProgramaSinSpring {
	public static void main(String[] args) {
		//construimos instancias
		Persona persona=new Persona();
		Persona pareja = new Persona();
		
		Tierra tierra = Tierra.getInstance();
		
		EnteSuperior dios = new EnteSuperior();
		
		Persona recienNacido = dios.crearPersona();
		
		//las particularizamos
		persona.setNombre("fernando");
		persona.setEdad(39);

		pareja.setNombre("lucia");
		pareja.setEdad(31);
		
		Collection<Persona> habitantes = new ArrayList<Persona>();
		
		habitantes.add(persona);
		habitantes.add(pareja);
		habitantes.add(recienNacido);
		
		tierra.setHabitantes(habitantes);
		
		//Inyectamos dependencias
		persona.setPareja(pareja);
		pareja.setPareja(persona);
		
		//utilizamos el objeto
		System.out.println(tierra);
		
	}
}
