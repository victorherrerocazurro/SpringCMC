package javabeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.InitializingBean;

public class Persona implements Serializable, InitializingBean{

	private static final long serialVersionUID = 1L;

	//sintaxis para la DI
	//con value
	private String nombre;
	private int edad;
	//con ref
	private Persona pareja;
	//con list de value
	private List<String>telefonos;
	//con set de refs
	private Set<Persona> amigos;
	//con map de entry de key y value
	private Map<String,Float>calificaciones;
	//con properties
	private Properties colores;
	
	public Persona() {}
	
	public Persona(String nombre, int edad, Persona pareja) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.pareja = pareja;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		//return "Persona [nombre=" + nombre + ", edad=" + edad + ", pareja=" + pareja + "]";
		return ToStringBuilder.reflectionToString(this);
	}

	public Persona getPareja() {
		return pareja;
	}

	public void setPareja(Persona pareja) {
		this.pareja = pareja;
	}

	public List<String> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<String> telefonos) {
		this.telefonos = telefonos;
	}

	public Set<Persona> getAmigos() {
		return amigos;
	}

	public void setAmigos(Set<Persona> amigos) {
		this.amigos = amigos;
	}

	public Map<String,Float> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(Map<String,Float> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public Properties getColores() {
		return colores;
	}

	public void setColores(Properties colores) {
		this.colores = colores;
	}
	
	public void inicializar(){
		System.out.println("una persona construida e inicializada "+this);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("instancia construida e inicializada "+this);
	}

}
