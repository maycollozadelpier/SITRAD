package detel.copere.ejercito.mil.pe.models.service;

import java.util.List;

import detel.copere.ejercito.mil.pe.models.entity.TotalTipoDocumento;

public interface ITotalTipoDocumentoService {

	List<TotalTipoDocumento> totalTipoDoc(String codUnidad);
	
}
