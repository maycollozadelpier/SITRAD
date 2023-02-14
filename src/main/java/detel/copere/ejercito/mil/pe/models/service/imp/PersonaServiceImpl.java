package detel.copere.ejercito.mil.pe.models.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import detel.copere.ejercito.mil.pe.models.dao.IPersonaDao;
import detel.copere.ejercito.mil.pe.models.entity.Persona;
import detel.copere.ejercito.mil.pe.models.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaDao PersonaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Persona> findAll() {
		return (List<Persona>) PersonaDao.findAll();
	}


	@Override
	@Transactional
	public void save(Persona Persona) {
		PersonaDao.save(Persona);
	}

	@Override
	@Transactional(readOnly = true)
	public Persona findById(Integer personaId) {
		return PersonaDao.findById(personaId).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Integer personaId) {
		PersonaDao.deleteById(personaId);
	}

}
