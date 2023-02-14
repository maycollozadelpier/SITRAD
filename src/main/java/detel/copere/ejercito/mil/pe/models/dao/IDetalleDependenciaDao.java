package detel.copere.ejercito.mil.pe.models.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import detel.copere.ejercito.mil.pe.models.entity.DetalleDependencia;

public interface IDetalleDependenciaDao extends JpaRepository<DetalleDependencia, String>{

	List<DetalleDependencia> findByTipUnidad(String tipUnidad);
	

}
