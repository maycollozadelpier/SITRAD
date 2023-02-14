package detel.copere.ejercito.mil.pe.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import detel.copere.ejercito.mil.pe.models.entity.Brigada;

public interface IBrigadaDao extends JpaRepository<Brigada, String> {
	List<Brigada> findBynucleoCodigo(String nucleoCodigo);
	
}
