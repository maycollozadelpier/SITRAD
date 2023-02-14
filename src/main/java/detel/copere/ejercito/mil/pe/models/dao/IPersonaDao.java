package detel.copere.ejercito.mil.pe.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import detel.copere.ejercito.mil.pe.models.entity.Persona;

public interface IPersonaDao extends JpaRepository<Persona, Integer>{

}
