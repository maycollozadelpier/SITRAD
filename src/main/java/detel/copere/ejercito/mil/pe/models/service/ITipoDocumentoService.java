package detel.copere.ejercito.mil.pe.models.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import detel.copere.ejercito.mil.pe.models.entity.TipoDocumento;

public interface ITipoDocumentoService {

	List<TipoDocumento> findAll();
	
	Page<TipoDocumento> findAll(Pageable pageable);
	
	void save(TipoDocumento TipoDocumento);
	
	TipoDocumento findById(String TipoDocumentoCodigo);
	
	void delete(String TipoDocumentoCodigo);
	
	
}
