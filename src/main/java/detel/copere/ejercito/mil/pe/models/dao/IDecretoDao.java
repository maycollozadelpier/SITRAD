package detel.copere.ejercito.mil.pe.models.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import detel.copere.ejercito.mil.pe.models.entity.Decreto;

public interface IDecretoDao extends JpaRepository<Decreto, String>{
//repositorio interfase 

	List<Decreto> findByIdEstadoAndIdUnidad(String idEstado,String idUnidad);
	
}
