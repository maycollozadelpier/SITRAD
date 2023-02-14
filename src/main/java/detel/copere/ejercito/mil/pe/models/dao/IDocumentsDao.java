package detel.copere.ejercito.mil.pe.models.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import detel.copere.ejercito.mil.pe.models.entity.Documents;

public interface IDocumentsDao extends JpaRepository<Documents, String>{
//repositorio interfase 
	Documents findBydocumentoId(String documentoId);
	
	List<Documents> findByFechaRecepcionDoc(String fechaRecepcionDoc);
		
	List<Documents> findByIdUnidadResponsable(String unidadResponsable);
	
	List<Documents> findByIdEstadoAndIdUnidadRemitente(String idEstado,String idUnidadRemitente);
	 
	List<Documents> findByIdEstadoAndIdUnidadResponsable(String idEstado,String idUnidadResponsable);
	 
	List<Documents> findByEstadoRegistro(Integer estadoRegistro);
	
	List<Documents> findByIdEstado(String idEstado);
	
	List<Documents> findByIdEstadoAndIdUnidadResponsableAndAnioAndFechaRecepcionDocBetween(String idEstado,String unidadResponsable,String anio,String fechaRecepcionDocI ,String fechaRecepcionDocF);
	
	List<Documents> findByIdEstadoAndIdUnidadRemitenteAndAnioAndFechaRecepcionDocBetween(String idEstado,String idUnidadRemitente,String anio,String fechaRecepcionDocI ,String fechaRecepcionDocF);

	List<Documents> findByIdUnidadResponsableAndAnioAndFechaRecepcionDoc(String unidadResponsable,String anio,String fechaRecepcionDoc);
	
	List<Documents> findByEstadoRegistroAndAnioAndFechaRecepcionDoc(Integer estadoRegistro,String anio,String fechaRecepcionDoc);
	
	
}
