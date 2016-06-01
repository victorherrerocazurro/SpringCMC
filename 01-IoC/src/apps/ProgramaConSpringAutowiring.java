package apps;

import java.util.Locale;

import javabeans.Persona;
import javabeans.Tierra;
import javabeans.autowiring.Cliente;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProgramaConSpringAutowiring {
	public static void main(String[] args) {
		//creamos la fabrica de javabeans
		ApplicationContext fabrica = 
				new ClassPathXmlApplicationContext("autowiring.xml");
		
		Cliente cliente = fabrica.getBean(Cliente.class);
		
		System.out.println(cliente);
		
		
	}
}
