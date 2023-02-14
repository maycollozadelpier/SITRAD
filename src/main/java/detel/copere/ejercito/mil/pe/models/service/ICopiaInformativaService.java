package detel.copere.ejercito.mil.pe.models.service;

import detel.copere.ejercito.mil.pe.models.entity.CopiaInformativa;

public interface ICopiaInformativaService {

	void save(CopiaInformativa CopiaInformativa);
	
	String estadocopiainformativa(String iddoc ,String idcopinf,String estdado)throws Exception;
}
