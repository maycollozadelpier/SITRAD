package detel.copere.ejercito.mil.pe.models.dao;

import java.util.List;


import detel.copere.ejercito.mil.pe.models.entity.DatosGenerales;
import detel.copere.ejercito.mil.pe.models.entity.Documento;

public interface IDatosGeneralesDao{

	public DatosGenerales getDatosGenerales(String username);
	
	public List<DatosGenerales> getListaUsuarios();
	
	public Documento getDocReferencia(String docreferencia);
}
