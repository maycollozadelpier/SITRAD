package detel.copere.ejercito.mil.pe.models.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import detel.copere.ejercito.mil.pe.models.entity.Clasificacion;

public interface IClasificacionService {

	List<Clasificacion> findAll();
	
	Page<Clasificacion> findAll(Pageable pageable);
	
	void save(Clasificacion Clasificacion);
	
	Clasificacion findById(String ClasificacionCodigo);
	
	void delete(String ClasificacionCodigo);
	
	
}
