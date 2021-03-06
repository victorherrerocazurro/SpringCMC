package com.aeat.portalparejas.modelo.negocio;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.aeat.portalparejas.modelo.entidades.Persona;
import com.aeat.portalparejas.modelo.servicios.ServicioParejasImpl;
import com.aeat.portalparejas.persistencia.dao.PersonaDao;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class ServicioParejasImplTest {

	@Test
	public void test() {
		//Subject Under Test
		ServicioParejasImpl sut = new ServicioParejasImpl();
		
		//Dato de prueba (entrada)
		Persona persona = new Persona("Victor", 22, 2.00f, 'M');
		//Dato de prueba (salida)
		long resultadoEsperado = 1;
				
		PersonaDao mock = Mockito.mock(PersonaDao.class);
		
		Mockito.when(mock.insertar(persona)).thenReturn(1l);
		//Mockito.when(mock.insertar(Mockito.any(Persona.class))).thenReturn(0l);
		
		/*PersonaDao personaDaoMock = new PersonaDao() {
			
			@Override
			public long insertar(Persona persona) {
				// TODO Auto-generated method stub
				if(persona.getNombre().equals("Victor")){
					return 1;
				} else {
					return 0;
				}
			}
			
			@Override
			public Persona getById(long id) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Collection<Persona> getAll() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void borrarById(long id) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void borrar(Persona persona) {
				// TODO Auto-generated method stub
				
			}
		};*/
		
		sut.setDao(mock);		
		
		//La ejecucion del SUT
		long resultadoObtenido = sut.insert(persona);
		
		//Verificacion
		Assert.assertEquals(resultadoEsperado, resultadoObtenido);
	}
}
