package com.aeat.portalparejas.persistencia.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.aeat.portalparejas.modelo.entidades.Persona;
import com.aeat.portalparejas.persistencia.dao.jdbc.RowMapperPersonaImpl;

public class PersonaDaoSimpleJdbcTemplateImpl implements PersonaDao {

	private NamedParameterJdbcTemplate template;
	
	public NamedParameterJdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(NamedParameterJdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public long insertar(Persona persona) {
		Map<String, Object> param = obtainMapFromPersona(persona);
		return getTemplate()
				.update(
						"insert into portalparejas.personas (nombre,edad,altura,genero) values (:nombre,:edad,:altura,:genero)"
						,param );
	}
	
	public long editar(Persona persona) {
		Map<String, Object> param = obtainMapFromPersona(persona);
		return getTemplate().update("update from persona set nombre = :nombre, ....", param);
	}

	@Override
	public void borrar(Persona persona) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", persona.getId());
		getTemplate().update("delete from portalparejas.personas where idpersona = :id", param);

	}

	@Override
	public void borrarById(long id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		getTemplate().update("delete from portalparejas.personas where idpersona = :id", param);

	}

	@Override
	public Collection<Persona> getAll() {
		return getTemplate().query("select * from portalparejas.personas", new HashMap<String, Object>(), 
				new RowMapperPersonaImpl());
	}

	@Override
	public Persona getById(long id) {
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", id);
			
			return (Persona)  getTemplate().queryForObject("select * from portalparejas.personas where idpersona=?",
								param,
								new RowMapperPersonaImpl());
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	
	
	private Map<String, Object> obtainMapFromPersona(Persona persona) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("nombre", persona.getNombre());
		param.put("edad",persona.getEdad() );
		param.put("altura", persona.getAltura());
		param.put("genero", String.valueOf(persona.getGenero()));
		return param;
	}

}