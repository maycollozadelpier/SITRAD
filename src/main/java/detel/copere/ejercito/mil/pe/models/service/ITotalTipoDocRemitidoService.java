package detel.copere.ejercito.mil.pe.models.service;

import java.util.List;

import detel.copere.ejercito.mil.pe.models.entity.TotalTipoDocRemitido;

public interface ITotalTipoDocRemitidoService {

	List<TotalTipoDocRemitido> totalTipoDocRemitido(String codUnidadRemi);
	
}
