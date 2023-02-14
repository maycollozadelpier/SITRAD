package detel.copere.ejercito.mil.pe.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import detel.copere.ejercito.mil.pe.models.entity.Documento;

public interface IDocumentoDao extends JpaRepository<Documento, Long>{
//repositorio interfase 
	List<Documento> findByestadoRegistro(Integer estadoRegistro);
	
	Documento findBydocumentoId(Long documentoId);
	
	
//	Documento findBydocumentoReferencia(String documentoReferencia);
}
