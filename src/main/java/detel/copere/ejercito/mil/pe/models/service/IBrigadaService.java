package detel.copere.ejercito.mil.pe.models.service;

import java.util.List;

import detel.copere.ejercito.mil.pe.models.entity.Brigada;

public interface IBrigadaService {

	List<Brigada> listarporNucleo(String nucleoCodigo);
	
}
