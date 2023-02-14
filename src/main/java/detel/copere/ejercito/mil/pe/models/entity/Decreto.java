package detel.copere.ejercito.mil.pe.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "SITRAD_DECRETO_DOCUMENTOS")
@Immutable
public class Decreto implements Serializable {

	private static final long serialVersionUID = 1L;

//	NID_DOCUMENTO
	@Id
	@Column(name = "NID_DOCUMENTO")
	private String documentoId;

//	ANIO
	@Column(name = "ANIO")
	private String anio;
	
//	VNUMERO_DOCUMENTO
	@Column(name = "VNUMERO_DOCUMENTO")
	private String numDoc;
	
//	VTIPO_ORGANIZACION
	@Column(name = "VTIPO_ORGANIZACION")
	private String organizacion;
	
//	VID_TIPO_DOC
	@Column(name = "VID_TIPO_DOC")
	private String idTipoDoc;
	
//	VDESCRIPCION_DOC
	@Column(name = "VDESCRIPCION_DOC")
	private String acronimoTipoDoc;
	
//	NID_TIPO_CLASIFICACION
	@Column(name = "NID_TIPO_CLASIFICACION")
	private String idClasificacion;
	
//	VDESCRIPCION_CLASIFICACION
	@Column(name = "VDESCRIPCION_CLASIFICACION")
	private String acronimoClasificacion;
	
//	VID_TIPO_ESTADO
	@Column(name = "VID_TIPO_ESTADO")
	private String idEstado;
	
//	VDESCRIPCION_ESTADO
	@Column(name = "ESTADO")
	private String acronimoEstado;
	
////	VASUNTO_DOCUMENTO
//	@Column(name = "VASUNTO_DOCUMENTO")
//	private String asunto;
	
//	VREF_DOCUMENTO
	@Column(name = "VREF_DOCUMENTO")
	private String documentoReferencia;
	
//	NESTADO_REGISTRO
	@Column(name = "NESTADO_REGISTRO")
	private Integer estadoRegistro;
	
//	DFECHA_DOCUMENTO
	@Column(name = "DFECHA_DOCUMENTO")
	private String fechaDoc;
	
//	VRESPUESTA_DOCUMENTO
	@Column(name = "VRESPUESTA_DOCUMENTO")
	private String respuestaDoc;
	
//	VDOC_ARCHIVO
	@Column(name = "VDOC_ARCHIVO")
	private String archivo;
	
//	UNIDAD
	@Column(name = "UNIDAD")
	private String idUnidad;
	
//	COD_DECRETO
	@Column(name = "COD_DECRETO")
	private String codDecreto;
	
//	ACRONIMO_DECRETO
	@Column(name = "ACRONIMO_DECRETO")
	private String acronimoDecreto;
	
//	COMENTARIO
	@Column(name = "COMENTARIO")
	private String comentario;
	
//	COD_PRIORIDAD
	@Column(name = "COD_PRIORIDAD")
	private String prioridad;
	
//	ACRONIMO_PRIORIDAD
	@Column(name = "ACRONIMO_PRIORIDAD")
	private String acronimoPrioridad;



	public String getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(String documentoId) {
		this.documentoId = documentoId;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public String getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(String organizacion) {
		this.organizacion = organizacion;
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

	public String getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}

	public String getAcronimoEstado() {
		return acronimoEstado;
	}

	public void setAcronimoEstado(String acronimoEstado) {
		this.acronimoEstado = acronimoEstado;
	}

//	public String getAsunto() {
//		return asunto;
//	}
//
//	public void setAsunto(String asunto) {
//		this.asunto = asunto;
//	}

	public String getDocumentoReferencia() {
		return documentoReferencia;
	}

	public void setDocumentoReferencia(String documentoReferencia) {
		this.documentoReferencia = documentoReferencia;
	}

	public Integer getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(Integer estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getFechaDoc() {
		return fechaDoc;
	}

	public void setFechaDoc(String fechaDoc) {
		this.fechaDoc = fechaDoc;
	}

	public String getRespuestaDoc() {
		return respuestaDoc;
	}

	public void setRespuestaDoc(String respuestaDoc) {
		this.respuestaDoc = respuestaDoc;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(String idUnidad) {
		this.idUnidad = idUnidad;
	}

	public String getCodDecreto() {
		return codDecreto;
	}

	public void setCodDecreto(String codDecreto) {
		this.codDecreto = codDecreto;
	}

	public String getAcronimoDecreto() {
		return acronimoDecreto;
	}

	public void setAcronimoDecreto(String acronimoDecreto) {
		this.acronimoDecreto = acronimoDecreto;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getAcronimoPrioridad() {
		return acronimoPrioridad;
	}

	public void setAcronimoPrioridad(String acronimoPrioridad) {
		this.acronimoPrioridad = acronimoPrioridad;
	}

	@Override
	public String toString() {
		return "Documents [documentoId=" + documentoId + ", anio=" + anio + ", numDoc=" + numDoc + ", organizacion="
				+ organizacion + ", idTipoDoc=" + idTipoDoc + ", acronimoTipoDoc=" + acronimoTipoDoc
				+ ", idClasificacion=" + idClasificacion + ", acronimoClasificacion=" + acronimoClasificacion
				+ ", idEstado=" + idEstado + ", acronimoEstado=" + acronimoEstado 
				+ ", documentoReferencia=" + documentoReferencia + ", estadoRegistro=" + estadoRegistro + ", fechaDoc="
				+ fechaDoc + ", respuestaDoc=" + respuestaDoc + ", archivo=" + archivo + ", idUnidad=" + idUnidad
				+ ", codDecreto=" + codDecreto + ", acronimoDecreto=" + acronimoDecreto + ", comentario=" + comentario
				+ ", prioridad=" + prioridad + ", acronimoPrioridad=" + acronimoPrioridad + "]";
	}
	
}