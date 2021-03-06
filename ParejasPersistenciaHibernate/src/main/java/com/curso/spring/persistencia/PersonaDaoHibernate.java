package com.curso.spring.persistencia;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.curso.spring.entidades.Persona;

@Repository("dao")
public class PersonaDaoHibernate implements PersonaDao {

	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	/* (non-Javadoc)
	 * @see com.curso.spring.persistencia.PersonaDao#insertar(com.curso.spring.entidades.Persona)
	 */
	@Override
	public void insertar(Persona p){
		
	}
	
	/* (non-Javadoc)
	 * @see com.curso.spring.persistencia.PersonaDao#borrar(java.lang.Integer)
	 */
	@Override
	public void borrar(Integer id){
		
	}
	
	/* (non-Javadoc)
	 * @see com.curso.spring.persistencia.PersonaDao#editar(com.curso.spring.entidades.Persona)
	 */
	@Override
	public void editar(Persona p){
		
	}
	
	/* (non-Javadoc)
	 * @see com.curso.spring.persistencia.PersonaDao#consultarPorId(java.lang.Integer)
	 */
	@Override
	public Persona consultarPorId(Integer Id){
		return null;
	}

	@Override
	public List<Persona> consultarTodos() {
		System.out.println("Consultar todos de Hibernate");
		return null;
	}
	
}
