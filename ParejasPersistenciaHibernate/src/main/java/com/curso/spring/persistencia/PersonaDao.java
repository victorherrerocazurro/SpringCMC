package com.curso.spring.persistencia;

import java.util.List;

import com.curso.spring.entidades.Persona;

public interface PersonaDao {

	void insertar(Persona p);

	void borrar(Integer id);

	void editar(Persona p);

	Persona consultarPorId(Integer Id);
	
	List<Persona> consultarTodos();

}