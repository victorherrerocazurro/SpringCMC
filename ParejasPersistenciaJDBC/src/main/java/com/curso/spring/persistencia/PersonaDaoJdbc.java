package com.curso.spring.persistencia;

import java.util.List;

import javax.sql.DataSource;

import com.curso.spring.entidades.Persona;

public class PersonaDaoJdbc implements PersonaDao{
	
	private DataSource ds;

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public void insertar(Persona p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(Persona p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Persona consultarPorId(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> consultarTodos() {
		System.out.println("Consultar todos de JDBC");
		return null;
	}	
}
