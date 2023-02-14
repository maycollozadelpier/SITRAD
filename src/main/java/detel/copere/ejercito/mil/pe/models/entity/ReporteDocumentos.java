package detel.copere.ejercito.mil.pe.models.entity;

import java.io.Serializable;

import javax.persistence.Column;

public class ReporteDocumentos implements Serializable {

//	VUNIDAD_CODIGO_RESP
	@Column(name = "VUNIDAD_CODIGO_RESP")
	private String idUnidadResponsable;
	
//	UU_DESC_RESP
	@Column(name = "UU_DESC_RESP")
	private String unidadResponsable;
	
//	VID_TIPO_DOC
	@Column(name = "VID_TIPO_DOC")
	private String idTipoDoc;

//	VDESCRIPCION_DOC
	@Column(name = "VDESCRIPCION_DOC")
	private String acronimoTipoDoc;

//	VANIO_DOCUMENTO
	@Column(name = "VANIO_DOCUMENTO")
	private String anio;

//	NID_TIPO_CLASIFICACION
	@Column(name = "NID_TIPO_CLASIFICACION")
	private String idClasificacion;

//	VDESCRIPCION_CLASIFICACION
	@Column(name = "VDESCRIPCION_CLASIFICACION")
	private String acronimoClasificacion;

//	DFECHA_REC_DOCUMENTO
	@Column(name = "DFECHA_REC_DOCUMENTO")
	private String fechaRecepcionDoc;

	public ReporteDocumentos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReporteDocumentos(String idUnidadResponsable, String unidadResponsable, String idTipoDoc,
			String acronimoTipoDoc, String anio, String idClasificacion, String acronimoClasificacion,
			String fechaRecepcionDoc) {
		super();
		this.idUnidadResponsable = idUnidadResponsable;
		this.unidadResponsable = unidadResponsable;
		this.idTipoDoc = idTipoDoc;
		this.acronimoTipoDoc = acronimoTipoDoc;
		this.anio = anio;
		this.idClasificacion = idClasificacion;
		this.acronimoClasificacion = acronimoClasificacion;
		this.fechaRecepcionDoc = fechaRecepcionDoc;
	}



	public String getIdUnidadResponsable() {
		return idUnidadResponsable;
	}

	public void setIdUnidadResponsable(String idUnidadResponsable) {
		this.idUnidadResponsable = idUnidadResponsable;
	}

	public String getUnidadResponsable() {
		return unidadResponsable;
	}

	public void setUnidadResponsable(String unidadResponsable) {
		this.unidadResponsable = unidadResponsable;
	}

	public String getIdTipoDoc() {
		return idTipoDoc;
	}

	public void setIdTipoDoc(String idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}

	public String getAcronimoTipoDoc() {
		return acronimoTipoDoc;
	}

	public void setAcronimoTipoDoc(String acronimoTipoDoc) {
		this.acronimoTipoDoc = acronimoTipoDoc;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getIdClasificacion() {
		return idClasificacion;
	}

	public void setIdClasificacion(String idClasificacion) {
		this.idClasificacion = idClasificacion;
	}

	public String getAcronimoClasificacion() {
		return acronimoClasificacion;
	}

	public void setAcronimoClasificacion(String acronimoClasificacion) {
		this.acronimoClasificacion = acronimoClasificacion;
	}

	public String getFechaRecepcionDoc() {
		return fechaRecepcionDoc;
	}

	public void setFechaRecepcionDoc(String fechaRecepcionDoc) {
		this.fechaRecepcionDoc = fechaRecepcionDoc;
	}



	@Override
	public String toString() {
		return "ReporteDocumentos [idUnidadResponsable=" + idUnidadResponsable + ", unidadResponsable="
				+ unidadResponsable + ", idTipoDoc=" + idTipoDoc + ", acronimoTipoDoc=" + acronimoTipoDoc + ", anio="
				+ anio + ", idClasificacion=" + idClasificacion + ", acronimoClasificacion=" + acronimoClasificacion
				+ ", fechaRecepcionDoc=" + fechaRecepcionDoc + "]";
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
