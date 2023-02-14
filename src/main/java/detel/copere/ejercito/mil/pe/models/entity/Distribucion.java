package detel.copere.ejercito.mil.pe.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SITRAD_DISTRIBUCION")

public class Distribucion {

	@Id
	@Column(name = "ID_DISTRIBUCION")
	private String  idDistribucion;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	public Distribucion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdDistribucion() {
		return idDistribucion;
	}

	public void setIdDistribucion(String idDistribucion) {
		this.idDistribucion = idDistribucion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
 

}
