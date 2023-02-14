package detel.copere.ejercito.mil.pe.models.service;

import java.util.List;

import detel.copere.ejercito.mil.pe.models.entity.Unidad;

public interface IUnidadService {

	List<Unidad> listarunidades(String brigadaCodigo);
	
	List<Unidad> listaDependencias(String nucleoCodigo, String brigadaCodigo);
	
	List<Unidad> listarunidadescopiainf();
	
}
