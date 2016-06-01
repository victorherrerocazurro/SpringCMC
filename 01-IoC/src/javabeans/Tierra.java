package javabeans;

import java.util.Collection;

import org.springframework.beans.factory.InitializingBean;

public class Tierra implements InitializingBean{
	private static Tierra instance;
	
	private Collection<Persona> habitantes;
	
	@Override
	public String toString() {
		return "Tierra [habitantes=" + habitantes + "]";
	}

	public Collection<Persona> getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(Collection<Persona> habitantes) {
		this.habitantes = habitantes;
	}

	static {
		instance = new Tierra();
	}
	
	private Tierra() {
	}
	
	public static Tierra getInstance() {
		return instance;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("instancia construida e inicializada "+this);
	}
}
