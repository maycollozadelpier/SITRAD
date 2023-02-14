package detel.copere.ejercito.mil.pe.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import detel.copere.ejercito.mil.pe.models.entity.DetalleDependencia;

public interface IDashboardDao extends JpaRepository<DetalleDependencia, String>{
  
	List<DetalleDependencia> findByCodigoUnidadAndTipUnidad(String codigoUnidad, String tipUnidad);
	
//	DetalleDependencia findByCodigoUnidad(String codigoUnidad);
	
}
