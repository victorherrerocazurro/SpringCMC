package com.aeat.portalparejas.persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

import com.aeat.portalparejas.modelo.entidades.Persona;

public class PersonaDaoJdbcImpl implements PersonaDao {
	
	private DataSource dataSource;
			
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/* (non-Javadoc)
	 * @see com.aeat.portalparejas.persistencia.dao.PersonaDao#insertar(com.aeat.portalparejas.modelo.entidades.Persona)
	 */
	@Override
	public long insertar(Persona persona){
		Connection cn = null;
		//obtenemos una conexion
		try {
			cn=dataSource.getConnection();
			PreparedStatement pst = 
					cn.prepareStatement("insert into portalparejas.personas (nombre,edad,altura,genero) values (?,?,?,?)");
			pst.setString(1, persona.getNombre());
			pst.setInt(2, persona.getEdad());
			pst.setDouble(3, persona.getAltura());
			pst.setString(4, String.valueOf(persona.getGenero()));
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Insertada la persona: " + persona);
		
		return persona.getId();
	}
	
	/* (non-Javadoc)
	 * @see com.aeat.portalparejas.persistencia.dao.PersonaDao#borrar(com.aeat.portalparejas.modelo.entidades.Persona)
	 */
	@Override
	public void borrar(Persona persona) {
		Connection cn = null;
		//obtenemos una conexion
		try {
			cn=dataSource.getConnection();
			PreparedStatement pst = 
					cn.prepareStatement("delete from portalparejas.personas where idpersona = ?");
			pst.setLong(1, persona.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Borrada la persona: " + persona);
	}
	
	/* (non-Javadoc)
	 * @see com.aeat.portalparejas.persistencia.dao.PersonaDao#borrarById(long)
	 */
	@Override
	public void borrarById(long id) {
		Connection cn = null;
		//obtenemos una conexion
		try {
			cn=dataSource.getConnection();
			PreparedStatement pst = 
					cn.prepareStatement("delete from portalparejas.personas where idpersona = ?");
			pst.setLong(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Borrada la persona con id: " + id);
	}
	
	/* (non-Javadoc)
	 * @see com.aeat.portalparejas.persistencia.dao.PersonaDao#getAll()
	 */
	@Override
	public Collection<Persona> getAll() {
		Collection<Persona> total = new ArrayList<Persona>();
		Connection cn = null;
		//obtenemos una conexion
		try {
			cn=dataSource.getConnection();
			PreparedStatement pst = 
					cn.prepareStatement("select idpersona,nombre,edad,altura,genero from portalparejas.personas");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Persona p = mapperPersona(rs);
				total.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Las personas encontradas son: " + total);
		return total;
	}

	private Persona mapperPersona(ResultSet rs) throws SQLException {
		Persona p = new Persona(rs.getLong(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), rs.getString(5).charAt(0));
		return p;
	}
	
	/* (non-Javadoc)
	 * @see com.aeat.portalparejas.persistencia.dao.PersonaDao#getById(long)
	 */
	@Override
	public Persona getById(long id){
		Persona p = null;
		Connection cn = null;
		//obtenemos una conexion
		try {
			cn=dataSource.getConnection();
			PreparedStatement pst = 
					cn.prepareStatement("select idpersona,nombre,edad,altura,genero from portalparejas.personas where idpersona = ?");
			pst.setLong(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				p =  mapperPersona(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("La persona encontrada con id: " + id + " es " + p);
		return p;
	}
}
