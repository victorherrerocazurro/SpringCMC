package com.aeat.portalparejas.persistencia.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aeat.portalparejas.modelo.entidades.Persona;

public class RowMapperPersonaImpl implements RowMapper<Persona> {

	@Override
	public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Persona(rs.getLong("idpersona"), 
				rs.getString("nombre"), 
				rs.getInt("edad"),
				rs.getFloat("altura"),
				rs.getString("genero").charAt(0));
	}

}
