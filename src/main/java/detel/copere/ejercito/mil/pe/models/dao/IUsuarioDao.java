package detel.copere.ejercito.mil.pe.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import detel.copere.ejercito.mil.pe.models.entity.Usuario;

public interface IUsuarioDao  extends JpaRepository<Usuario, Long>{

	//buscar usuario por nombre
	Usuario  findByUsername(String username);
	
}
