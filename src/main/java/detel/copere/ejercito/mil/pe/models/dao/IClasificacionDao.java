package detel.copere.ejercito.mil.pe.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import detel.copere.ejercito.mil.pe.models.entity.Clasificacion;

public interface IClasificacionDao extends JpaRepository<Clasificacion, String>{
//repositorio interfase 
	//List<Clasificacion> findByClasificacionAbreviatura(String ClasificacionAbreviatura);
	
	
}
