package com.aplicacion.parejas.validadores;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.aplicacion.parejas.modelo.entidades.Persona;

public class PersonaValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Persona.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors e) {
		Persona persona = (Persona) obj;
		e.rejectValue("nombre", "formulario.persona.error.nombre");
	}
}
