package detel.copere.ejercito.mil.pe.models.service;

import java.util.List;


import detel.copere.ejercito.mil.pe.models.entity.Persona;

public interface IPersonaService {

	List<Persona> findAll();
	
	void save(Persona Persona);
	
	Persona findById(Integer personaId);
	
	void delete(Integer personaId);
	
	
}
