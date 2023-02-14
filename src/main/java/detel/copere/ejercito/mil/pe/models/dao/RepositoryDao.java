package detel.copere.ejercito.mil.pe.models.dao;

import java.util.List;

import detel.copere.ejercito.mil.pe.models.entity.Documents;

public interface RepositoryDao {

	public List<Documents>  getListRecibidos(String idEstado, String tipoDoc, String unidadResponsable,String fechaRecepcionDocI ,String fechaRecepcionDocF);
	public List<Documents>  getListRemitidos( String tipoDoc, String unidadremite,String fechaDociIni ,String fechaDocFin);
	public List<Documents>  getListRemitidosDiario(String unidadremite);
}
