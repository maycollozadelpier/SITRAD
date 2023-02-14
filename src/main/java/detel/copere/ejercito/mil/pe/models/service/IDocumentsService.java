package detel.copere.ejercito.mil.pe.models.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import detel.copere.ejercito.mil.pe.models.entity.Documento;
import detel.copere.ejercito.mil.pe.models.entity.Documents;
import detel.copere.ejercito.mil.pe.models.entity.ListasNative;

public interface IDocumentsService {

	List<Documents> findAll();
	
	Documents listaxID(String documentoId);
	
	List<Documents> listaXunidadResponsable(String unidadResponsable);
	
	List<Documents> listaXestadoYunidadRemitente(String idEstado, String idUnidadRemitente);
	
	List<Documents> listaXestadoYunidadResponsable(String idEstado, String idUnidadResponsable); //RECIBIDOS
	
	
	List<Documents> reporteRecibidos(String idEstado,String unidadResponsable,String anio,String fechaRecepcionDocI,String fechaRecepcionDocF);
	
	List<Documents> reporteRemitidos(String idEstado,String idUnidadRemitente,String anio,String fechaRecepcionDocI,String fechaRecepcionDocF);
	
	List<Documents> reporteDiario(String unidadResponsable,String anio,String fechaRecepcionDoc);
	
	List<Documents> reporteDiarioMesaPartes(Integer estadoRegistro,String anio,String fechaRecepcionDoc);
	
	List<Documents> listaDecretoSecretario(Integer estadoRegistro);
	
	List<Documents> pendientes(String idEstado);
	
	List<Documents> listaRegistroDiario(String fechaRecepcionDoc);
	
	Page<Documents> findAll(Pageable pageable);
	
	List<ListasNative> listarcomentario();
	List<Documents> 	listardocumentosrespondidos();
	
	List<Documento> listaunidadregistra(String unidad);
	List<Documento> listaunidadremite(String unidad);
	
	
	
	
	
	
}
