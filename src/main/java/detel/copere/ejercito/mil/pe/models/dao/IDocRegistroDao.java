package detel.copere.ejercito.mil.pe.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import detel.copere.ejercito.mil.pe.models.entity.DocRegistrado;

@Repository
public interface IDocRegistroDao extends JpaRepository<DocRegistrado, Integer> {

}
