package detel.copere.ejercito.mil.pe.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "SITRAD_LISTA_DOCUMENTOS")
@Immutable
public class Documents implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	NID_DOCUMENTO
	@Id
	@Column(name = "NID_DOCUMENTO", columnDefinition = "NUMBER(15)")
	private String documentoId;

//	VANIO_DOCUMENTO
	@Column(name = "VANIO_DOCUMENTO")
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
	@Column(name = "VDESCRIPCION_ESTADO")
	private String acronimoEstado;
	
//	VASUNTO_DOCUMENTO
	@Column(name = "VASUNTO_DOCUMENTO")
	private String asunto;
	
//	VDESCRIPCION_DOCUMENTO
	@Column(name = "VDESCRIPCION_DOCUMENTO")
	private String descripcion;
	
//	VREF_DOCUMENTO
	@Column(name = "VREF_DOCUMENTO")
	private String documentoReferencia;
	
//	NESTADO_REGISTRO
	@Column(name = "NESTADO_REGISTRO")
	private Integer estadoRegistro;
	
//	DFECHA_DOCUMENTO
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	@Column(name = "DFECHA_DOCUMENTO")
	private String fechaDoc;
	
//	DFECHA_REC_DOCUMENTO
	@Column(name = "DFECHA_REC_DOCUMENTO")
	private String fechaRecepcionDoc;
	
//	VRESPUESTA_DOCUMENTO
	@Column(name = "VRESPUESTA_DOCUMENTO")
	private String respuestaDoc;
	
//	VDOC_ARCHIVO
	@Column(name = "VDOC_ARCHIVO")
	private String archivo;
	
//	VNUCLEO_CODIGO_REMIT
	@Column(name = "VNUCLEO_CODIGO_REMIT")
	private String idNucRemitente;
	
//	NN_REMITE
	@Column(name = "NN_REMITE")
	private String nucleoRemitente;
	
//	VACTIVIDAD_CODIGO_REMIT
	@Column(name = "VACTIVIDAD_CODIGO_REMIT")
	private String idBrigadaRemitente;
	
//	GGUU_REMITE
	@Column(name = "GGUU_REMITE")
	private String brigadaRemitente;
	
//	VUNIDAD_CODIGO_REMIT
	@Column(name = "VUNIDAD_CODIGO_REMIT")
	private String idUnidadRemitente;
	
//	UU_REMITE
	@Column(name = "UU_REMITE")
	private String unidadRemitente;
	
//	VNUCLEO_CODIGO_RESP
	@Column(name = "VNUCLEO_CODIGO_RESP")
	private String idNucleoResponsable;
	
//	NN_RESP
	@Column(name = "NN_RESP")
	private String nucleoResponsable;
	
//	VACTIVIDAD_CODIGO_RESP
	@Column(name = "VACTIVIDAD_CODIGO_RESP")
	private String idBrigadaResponsable;
	
//	GGUU_RESP
	@Column(name = "GGUU_RESP")
	private String brigadaResponsable;
	
//	VUNIDAD_CODIGO_RESP
	@Column(name = "VUNIDAD_CODIGO_RESP")
	private String idUnidadResponsable;
	 
//	UU_DESC_RESP
	@Column(name = "UU_DESC_RESP")
	private String unidadResponsable;
	
//	VUSUARIO_ACTUALIZACION
	@Column(name = "VUSUARIO_ACTUALIZACION")
	private String usuarioActualiza;
	
//	VUSUARIO_ELIMINACION
	@Column(name = "VUSUARIO_ELIMINACION")
	private String usuarioElimina;
	
//	VUSUARIO_REGISTRO
	@Column(name = "VUSUARIO_REGISTRO")
	private String usuarioRegistra;
	


	public Documents() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Documents(String documentoId, String anio, String numDoc, String organizacion, String idTipoDoc,
			String acronimoTipoDoc, String idClasificacion, String acronimoClasificacion, String idEstado,
			String acronimoEstado, String asunto, String descripcion, String documentoReferencia,
			Integer estadoRegistro, String fechaDoc, String fechaRecepcionDoc, String respuestaDoc, String archivo,
			String idNucRemitente, String nucleoRemitente, String idBrigadaRemitente, String brigadaRemitente,
			String idUnidadRemitente, String unidadRemitente, String idNucleoResponsable, String nucleoResponsable,
			String idBrigadaResponsable, String brigadaResponsable, String idUnidadResponsable,
			String unidadResponsable, String usuarioActualiza, String usuarioElimina, String usuarioRegistra) {
		super();
		this.documentoId = documentoId;
		this.anio = anio;
		this.numDoc = numDoc;
		this.organizacion = organizacion;
		this.idTipoDoc = idTipoDoc;
		this.acronimoTipoDoc = acronimoTipoDoc;
		this.idClasificacion = idClasificacion;
		this.acronimoClasificacion = acronimoClasificacion;
		this.idEstado = idEstado;
		this.acronimoEstado = acronimoEstado;
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.documentoReferencia = documentoReferencia;
		this.estadoRegistro = estadoRegistro;
		this.fechaDoc = fechaDoc;
		this.fechaRecepcionDoc = fechaRecepcionDoc;
		this.respuestaDoc = respuestaDoc;
		this.archivo = archivo;
		this.idNucRemitente = idNucRemitente;
		this.nucleoRemitente = nucleoRemitente;
		this.idBrigadaRemitente = idBrigadaRemitente;
		this.brigadaRemitente = brigadaRemitente;
		this.idUnidadRemitente = idUnidadRemitente;
		this.unidadRemitente = unidadRemitente;
		this.idNucleoResponsable = idNucleoResponsable;
		this.nucleoResponsable = nucleoResponsable;
		this.idBrigadaResponsable = idBrigadaResponsable;
		this.brigadaResponsable = brigadaResponsable;
		this.idUnidadResponsable = idUnidadResponsable;
		this.unidadResponsable = unidadResponsable;
		this.usuarioActualiza = usuarioActualiza;
		this.usuarioElimina = usuarioElimina;
		this.usuarioRegistra = usuarioRegistra;
	}

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

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

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

	public String getFechaRecepcionDoc() {
		return fechaRecepcionDoc;
	}

	public void setFechaRecepcionDoc(String fechaRecepcionDoc) {
		this.fechaRecepcionDoc = fechaRecepcionDoc;
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

	public String getIdNucRemitente() {
		return idNucRemitente;
	}

	public void setIdNucRemitente(String idNucRemitente) {
		this.idNucRemitente = idNucRemitente;
	}

	public String getNucleoRemitente() {
		return nucleoRemitente;
	}

	public void setNucleoRemitente(String nucleoRemitente) {
		this.nucleoRemitente = nucleoRemitente;
	}

	public String getIdBrigadaRemitente() {
		return idBrigadaRemitente;
	}

	public void setIdBrigadaRemitente(String idBrigadaRemitente) {
		this.idBrigadaRemitente = idBrigadaRemitente;
	}

	public String getBrigadaRemitente() {
		return brigadaRemitente;
	}

	public void setBrigadaRemitente(String brigadaRemitente) {
		this.brigadaRemitente = brigadaRemitente;
	}

	public String getIdUnidadRemitente() {
		return idUnidadRemitente;
	}

	public void setIdUnidadRemitente(String idUnidadRemitente) {
		this.idUnidadRemitente = idUnidadRemitente;
	}

	public String getUnidadRemitente() {
		return unidadRemitente;
	}

	public void setUnidadRemitente(String unidadRemitente) {
		this.unidadRemitente = unidadRemitente;
	}

	public String getIdNucleoResponsable() {
		return idNucleoResponsable;
	}

	public void setIdNucleoResponsable(String idNucleoResponsable) {
		this.idNucleoResponsable = idNucleoResponsable;
	}

	public String getNucleoResponsable() {
		return nucleoResponsable;
	}

	public void setNucleoResponsable(String nucleoResponsable) {
		this.nucleoResponsable = nucleoResponsable;
	}

	public String getIdBrigadaResponsable() {
		return idBrigadaResponsable;
	}

	public void setIdBrigadaResponsable(String idBrigadaResponsable) {
		this.idBrigadaResponsable = idBrigadaResponsable;
	}

	public String getBrigadaResponsable() {
		return brigadaResponsable;
	}

	public void setBrigadaResponsable(String brigadaResponsable) {
		this.brigadaResponsable = brigadaResponsable;
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

	public String getUsuarioActualiza() {
		return usuarioActualiza;
	}

	public void setUsuarioActualiza(String usuarioActualiza) {
		this.usuarioActualiza = usuarioActualiza;
	}

	public String getUsuarioElimina() {
		return usuarioElimina;
	}

	public void setUsuarioElimina(String usuarioElimina) {
		this.usuarioElimina = usuarioElimina;
	}

	public String getUsuarioRegistra() {
		return usuarioRegistra;
	}

	public void setUsuarioRegistra(String usuarioRegistra) {
		this.usuarioRegistra = usuarioRegistra;
	}

	@Override
	public String toString() {
		return "Documents [documentoId=" + documentoId + ", anio=" + anio + ", numDoc=" + numDoc + ", organizacion="
				+ organizacion + ", idTipoDoc=" + idTipoDoc + ", acronimoTipoDoc=" + acronimoTipoDoc
				+ ", idClasificacion=" + idClasificacion + ", acronimoClasificacion=" + acronimoClasificacion
				+ ", idEstado=" + idEstado + ", acronimoEstado=" + acronimoEstado + ", asunto=" + asunto
				+ ", descripcion=" + descripcion + ", documentoReferencia=" + documentoReferencia + ", estadoRegistro="
				+ estadoRegistro + ", fechaDoc=" + fechaDoc + ", fechaRecepcionDoc=" + fechaRecepcionDoc
				+ ", respuestaDoc=" + respuestaDoc + ", archivo=" + archivo + ", idNucRemitente=" + idNucRemitente
				+ ", nucleoRemitente=" + nucleoRemitente + ", idBrigadaRemitente=" + idBrigadaRemitente
				+ ", brigadaRemitente=" + brigadaRemitente + ", idUnidadRemitente=" + idUnidadRemitente
				+ ", unidadRemitente=" + unidadRemitente + ", idNucleoResponsable=" + idNucleoResponsable
				+ ", nucleoResponsable=" + nucleoResponsable + ", idBrigadaResponsable=" + idBrigadaResponsable
				+ ", brigadaResponsable=" + brigadaResponsable + ", idUnidadResponsable=" + idUnidadResponsable
				+ ", unidadResponsable=" + unidadResponsable + ", usuarioActualiza=" + usuarioActualiza
				+ ", usuarioElimina=" + usuarioElimina + ", usuarioRegistra=" + usuarioRegistra + "]";
	}
	
	
}