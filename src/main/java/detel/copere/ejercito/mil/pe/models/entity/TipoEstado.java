package detel.copere.ejercito.mil.pe.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SITRAD_TIPO_ESTADO")
public class TipoEstado {

	@Id
	@Column(name = "VID_TIPO_ESTADO", nullable = false, length = 4)
	private String tipoEstadoId;
	
	@Column(name = "VDESCRIPCION_ESTADO", nullable = false)
	private String descripcion;


	@Column(name = "NESTADO_REGISTRO", nullable = false, length = 1)
	private Integer estadoRegistro;

	public TipoEstado() {
	
	}

	public String getTipoEstadoId() {
		return tipoEstadoId;
	}


	public void setTipoEstadoId(String tipoEstadoId) {
		this.tipoEstadoId = tipoEstadoId;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getEstadoRegistro() {
		return estadoRegistro;
	}


	public void setEstadoRegistro(Integer estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
}
