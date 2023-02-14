package detel.copere.ejercito.mil.pe.models.service;


import java.util.List;

import detel.copere.ejercito.mil.pe.models.entity.Decreto;

public interface IDecretoService {

	
	List<Decreto> listaCopiaInformativa(String idEstado, String idUnidad);

	
}
