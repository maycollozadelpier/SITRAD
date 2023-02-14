package detel.copere.ejercito.mil.pe.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SITRAD_TIPO_CLASIFICACION")
public class Clasificacion {
	
	@Id
	@Column(name = "NID_TIPO_CLASIFICACION", nullable = false, length = 4)
	private String tipoClasificacionId;

	@Column(name = "VDESCRIPCION_CLASIFICACION")
	private String descripcion;

	@Column(name = "VOBSERVACION_CLASIFICACION")
	private String observacion;

	@Column(name = "NESTADO_REGISTRO", nullable = false)
	private Integer estadoRegistro;

	public Clasificacion() {

	}

	public String getTipoClasificacionId() {
		return tipoClasificacionId;
	}

	public void setTipoClasificacionId(String tipoClasificacionId) {
		this.tipoClasificacionId = tipoClasificacionId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(Integer estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}


}
