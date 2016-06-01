package com.aplicacion.parejas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/personas")
public class ServicioRestPersonaControlador {

	@RequestMapping(path="/{id}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Persona getPersona(@PathVariable("id") int id){
		return new Persona(1, "victor", "herrero", 37, "M", 1.85);
	}
	
	@RequestMapping(method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> getPersonas(){
		List<Persona> listadoPersonas = new ArrayList<Persona>();
		listadoPersonas.add(new Persona(1, "victor", "herrero", 37, "M", 1.85));
		listadoPersonas.add(new Persona(2, "juan", "herrero", 37, "M", 1.85));
		listadoPersonas.add(new Persona(3, "pedro", "herrero", 37, "M", 1.85));
		
		return listadoPersonas ;
	}
	
	@RequestMapping(
			method= RequestMethod.POST, 
			produces=MediaType.APPLICATION_JSON_VALUE, 
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public Persona postPersona(@RequestBody Persona persona){
		return persona;
	}
	
	@RequestMapping(
			path = "/{id}", 
			method = RequestMethod.PUT,
			produces=MediaType.APPLICATION_JSON_VALUE, 
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public Persona putPersona(
			@PathVariable("id") int id,
			@RequestBody Persona persona) {
		return persona;
	}

	@RequestMapping(
			path = "/{id}", 
			method = RequestMethod.DELETE,
			produces=MediaType.APPLICATION_JSON_VALUE, 
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public Persona borrarPersonaPorId(@PathVariable("id") int id) {
		return new Persona(id, "victor", "herrero", 37, "M", 1.85);
	}
}
