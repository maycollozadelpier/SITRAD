package detel.copere.ejercito.mil.pe.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import detel.copere.ejercito.mil.pe.models.entity.Nucleo;

public interface INucleoDao extends JpaRepository<Nucleo, String>{
//repositorio interfase 
	//List<Nucleo> findByNucleoAbreviatura(String nucleoAbreviatura);
	
	
}
