package detel.copere.ejercito.mil.pe.models.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import detel.copere.ejercito.mil.pe.models.entity.DocRegistrado;
import detel.copere.ejercito.mil.pe.models.entity.Documento;
import detel.copere.ejercito.mil.pe.models.entity.TipoEstado;

public interface IDocumentoService {

	List<Documento> findAll();
	
	List<Documento> listaRecibidos(Integer estadoRegistro);
	
	
	
	Page<Documento> findAll(Pageable pageable);
	
	void save(Documento Documento);
	
	public Documento buscarPorId(Long documentoId);
	
	void delete(Long DocumentoCodigo);
	
	Documento listaxID(Long documentoId);
	
	String DocRegistroIns(DocRegistrado docregistro);

	String updatetipoestado(Long iddoc ,String estadodoc);

//	 Documento buscarDocReferencia(String documentoReferencia);
	

}
