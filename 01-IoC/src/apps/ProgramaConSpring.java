package apps;

import java.util.Locale;

import javabeans.Persona;
import javabeans.Tierra;
import javabeans.autowiring.Cliente;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProgramaConSpring {
	public static void main(String[] args) {
		//creamos la fabrica de javabeans
		ApplicationContext fabrica = 
				new ClassPathXmlApplicationContext(
						new String[]{"personas.xml","maspersonas.xml"});
		
		//Obtencio de bean or ID
		Persona fernando = (Persona) fabrica.getBean("fernando");
		
		//Obtencion de Bean por tipo (solo debe existir un bean de este tipo)
		Tierra tierra = fabrica.getBean(Tierra.class);
		
		//Instanciar un objeto prototype y singleton
		Persona pablo1 = (Persona) fabrica.getBean("pablo-multirealidad");
		Persona pablo2 = (Persona) fabrica.getBean("pablo-multirealidad");
		Persona fernando2 = (Persona) fabrica.getBean("fernando");
		
		if(!pablo1.equals(pablo2)){
			System.out.println("distintos objetos en realidades distintas");
		} else {
			System.out.println("mismo objeto en misma realidad");
		}
		
		if(!fernando.equals(fernando2)){
			System.out.println("distintos objetos en realidades distintas");
		} else {
			System.out.println("mismo objeto en misma realidad");
		}
		
		Persona enrique = (Persona) fabrica.getBean("enrique");
		
		Cliente cliente = fabrica.getBean(Cliente.class);
		
		System.out.println(cliente);

		//CicloDeVida
		Persona anonimo = (Persona) fabrica.getBean("anonimo");
		
		String mensaje = fabrica.getMessage("saludo", null, Locale.getDefault());
		System.out.println(mensaje);
	}
}
