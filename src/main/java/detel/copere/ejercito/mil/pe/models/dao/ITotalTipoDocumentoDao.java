package detel.copere.ejercito.mil.pe.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import detel.copere.ejercito.mil.pe.models.entity.TotalTipoDocumento;

public interface ITotalTipoDocumentoDao extends JpaRepository<TotalTipoDocumento, String>{

	List<TotalTipoDocumento> findByCodUnidad(String codUnidad);
	
}
