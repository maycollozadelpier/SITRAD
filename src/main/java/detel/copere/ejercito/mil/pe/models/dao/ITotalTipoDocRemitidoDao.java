package detel.copere.ejercito.mil.pe.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import detel.copere.ejercito.mil.pe.models.entity.TotalTipoDocRemitido;


public interface ITotalTipoDocRemitidoDao extends JpaRepository<TotalTipoDocRemitido, String>{

	List<TotalTipoDocRemitido> findByCodUnidadRemi(String codUnidadRemi);
	
}
