package detel.copere.ejercito.mil.pe.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import detel.copere.ejercito.mil.pe.models.entity.TipoDocumento;

public interface ITipoDocumentoDao extends JpaRepository<TipoDocumento, String>{
//repositorio interfase 
	//List<TipoDocumento> findByTipoDocumentoAbreviatura(String TipoDocumentoAbreviatura);
	
	
}
