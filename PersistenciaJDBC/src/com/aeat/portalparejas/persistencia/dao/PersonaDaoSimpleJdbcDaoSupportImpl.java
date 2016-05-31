package com.aeat.portalparejas.persistencia.dao;

import java.util.Collection;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import com.aeat.portalparejas.modelo.entidades.Persona;
import com.aeat.portalparejas.persistencia.dao.jdbc.RowMapperPersonaImpl;

public class PersonaDaoSimpleJdbcDaoSupportImpl extends SimpleJdbcDaoSupport implements PersonaDao {

	@Override
	public long insertar(Persona persona) {
		return getJdbcTemplate().update("insert into portalparejas.personas (nombre,edad,altura,genero) values (?,?,?,?)",
				new Object[]{persona.getNombre(),persona.getEdad(),persona.getAltura(),String.valueOf(persona.getGenero())});
	}

	@Override
	public void borrar(Persona persona) {
		getJdbcTemplate().update("delete from portalparejas.personas where idpersona=?",
					new Object[]{persona.getId()});

	}

	@Override
	public void borrarById(long id) {
		getJdbcTemplate().update("delete from portalparejas.personas where idpersona=?",
					new Object[]{id});

	}

	@Override
	public Collection<Persona> getAll() {
		return getJdbcTemplate().query("select * from portalparejas.personas", 
				new RowMapperPersonaImpl());
	}

	@Override
	public Persona getById(long id) {
		try {
			return (Persona)  getJdbcTemplate().queryForObject("select * from portalparejas.personas where idpersona=?",
								new RowMapperPersonaImpl(),
								new Object[]{id});
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}
}