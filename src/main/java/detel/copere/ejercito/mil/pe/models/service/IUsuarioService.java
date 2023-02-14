package detel.copere.ejercito.mil.pe.models.service;

import java.util.List;

import detel.copere.ejercito.mil.pe.models.entity.Usuario;

public interface IUsuarioService {

	void guardar(Usuario Usuario);
	void eliminar(Long usuarioId);
	List<Usuario> buscarTodos();
	Usuario buscarPorUsername(String username);
	String cambiarclavesitrad(String username ,String password)throws Exception;
}
