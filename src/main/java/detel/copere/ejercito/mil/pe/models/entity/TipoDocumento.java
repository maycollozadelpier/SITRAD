package detel.copere.ejercito.mil.pe.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SITRAD_TIPO_DOCUMENTO")
public class TipoDocumento {
	@Id
	@Column(name = "VID_TIPO_DOC", nullable = false, length = 4)
	private String tipoDocumentoId;

	@Column(name = "VTIPO_DOC")
	private String tipoDocumento;

	@Column(name = "VDESCRIPCION_DOC")
	private String descripcion;

	@Column(name = "VOBSERVACION_DOC")
	private String observacion;

	@Column(name = "NESTADO_REGISTRO", nullable = false)
	private Integer estadoRegistro;

	public TipoDocumento() {

	}

	public String getTipoDocumentoId() {
		return tipoDocumentoId;
	}

	public void setTipoDocumentoId(String tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
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

	@Override
	public String toString() {
		return "TipoDocumento [tipoDocumentoId=" + tipoDocumentoId + ", tipoDocumento=" + tipoDocumento
				+ ", descripcion=" + descripcion + ", observacion=" + observacion + ", estadoRegistro=" + estadoRegistro
				+ "]";
	}
	
}
