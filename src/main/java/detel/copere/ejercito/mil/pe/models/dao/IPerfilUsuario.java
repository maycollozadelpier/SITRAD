package detel.copere.ejercito.mil.pe.models.dao;

import java.util.List;

import detel.copere.ejercito.mil.pe.models.entity.Perfil;

public interface IPerfilUsuario {

	public List<Perfil> getPerfil();
	public Long idpersona();
	void actualizarFoto(Long personaId, String foto);
	
}
