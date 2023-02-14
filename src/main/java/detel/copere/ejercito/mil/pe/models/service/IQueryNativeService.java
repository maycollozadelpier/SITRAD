package detel.copere.ejercito.mil.pe.models.service;

import java.util.List;

import detel.copere.ejercito.mil.pe.models.entity.GenericoNative;

public interface IQueryNativeService {
	
	List<GenericoNative> listarDecreto(String cod_dependencia) throws Exception;	
	List<GenericoNative> listarCopiaInformativa(String cod_dependencia) throws Exception;	

}
