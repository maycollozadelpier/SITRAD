package detel.copere.ejercito.mil.pe.models.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import detel.copere.ejercito.mil.pe.models.entity.Nucleo;

public interface INucleoService {

	List<Nucleo> findAll();
	
	Page<Nucleo> findAll(Pageable pageable);
	
	void save(Nucleo nucleo);
	
	Nucleo findById(String nucleoCodigo);
	
	void delete(String nucleoCodigo);
	
	
}
