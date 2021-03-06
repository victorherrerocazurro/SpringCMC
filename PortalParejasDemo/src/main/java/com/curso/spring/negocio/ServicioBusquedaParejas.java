package com.curso.spring.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.curso.spring.entidades.Persona;
import com.curso.spring.persistencia.PersonaDao;

@Service
public class ServicioBusquedaParejas {
	@Autowired
	@Qualifier("dao")
	private PersonaDao dao;

	public ServicioBusquedaParejas() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public ServicioBusquedaParejas(@Qualifier("dao") PersonaDao dao) {
		super();
		this.dao = dao;
	}

	public PersonaDao getDao() {
		return dao;
	}

	public void setDao(PersonaDao dao) {
		this.dao = dao;
	}

	public List<Persona> buscarAfines(Persona elQueBusca){
		
		List<Persona> candidatosASerAfines = dao.consultarTodos();
		
		return null;
	}
	
}
