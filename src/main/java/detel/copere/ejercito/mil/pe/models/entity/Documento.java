package detel.copere.ejercito.mil.pe.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "SITRAD_DOCUMENTO")
public class Documento {
 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_documento_id")
	@SequenceGenerator(name = "seq_documento_id", allocationSize = 1, sequenceName = "seq_documento_id")
	@Column(name = "NID_DOCUMENTO", nullable = false, length = 15)
	private Long documentoId;

	@Column(name = "VANIO_DOCUMENTO", nullable = true)
	private String anio;
	
	@Column(name = "UNIDAD_REGISTRO", nullable = true, length = 6)
	private String unidadregistro;

	@ManyToOne(optional = false)
	@JoinColumn(name = "VID_TIPO_DOC", nullable = true, updatable = false)
	private TipoDocumento tipoDocumento;

	@ManyToOne(optional = false)
	@JoinColumn(name = "NID_TIPO_CLASIFICACION", nullable = true, updatable = false)
	private Clasificacion clasificacion;

	@Column(name = "VNUMERO_DOCUMENTO", nullable = true)
	private String numeroDocumento;

	@Column(name = "VTIPO_ORGANIZACION", nullable = true, length = 1)
	private String tipoOrganizacion;

//	@Temporal(TemporalType.DATE)
//	 @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
//	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
//	@Column(name = "DFECHA_DOCUMENTO", nullable = true, columnDefinition = "TIMESTAMP(6)")
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy")

	
	
  @Column(name = "DFECHA_DOCUMENTO", nullable = true, columnDefinition = "TIMESTAMP(6)")
	private String fechaDocumento;

//	@Temporal(TemporalType.DATE)
//	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
//	@Column(name = "DFECHA_REC_DOCUMENTO", nullable = true, columnDefinition = "TIMESTAMP(6)")
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy")
	@Column(name = "DFECHA_REC_DOCUMENTO", nullable = true, columnDefinition = "TIMESTAMP(6)")
	private Date fechaRecepcion;

	@Column(name = "VREF_DOCUMENTO")
	private String documentoReferencia;

	@Column(name = "VASUNTO_DOCUMENTO", nullable = true, length = 5000)
	private String asunto;

	@ManyToOne(optional = false)
	@JoinColumn(name = "VID_TIPO_ESTADO", nullable = true)
	private TipoEstado tipoEstado;

	@Column(name = "VNUCLEO_CODIGO_REMIT", nullable = true, length = 2)
	private String nucleoRemitente; //nucleo remitente

	@Column(name = "VACTIVIDAD_CODIGO_REMIT", nullable = true, length = 4)
	private String brigadaRemitente; //gguu remitente

	@Column(name = "VUNIDAD_CODIGO_REMIT", nullable = true, length = 6)
	private String unidadRemitente; // unidad remitente 

	@Column(name = "VNUCLEO_CODIGO_RESP", nullable = true, length = 2)
	private String nucleoResponsable;

	@Column(name = "VACTIVIDAD_CODIGO_RESP", nullable = true, length = 4)
	private String brigadaResponsable;

	@Column(name = "VUNIDAD_CODIGO_RESP", nullable = true, length = 6)
	private String unidadResponsable;
  
	@Column(name = "VDOC_ARCHIVO", nullable = true, length = 36)
	private String archivo;

	@Column(name = "VUSUARIO_REGISTRO")
	private String usuarioRegistro;

	@Column(name = "VUSUARIO_ACTUALIZACION")
	private String usuarioActualizacion;

	@Column(name = "VUSUARIO_ELIMINACION")
	private String usuarioEliminacion;

	@Column(name = "VRESPUESTA_DOCUMENTO")
	private String respuesta;

	@Column(name = "NESTADO_REGISTRO", nullable = true, length = 1, precision = 1)
	private Integer estadoRegistro;

	@Column(name = "VDESCRIPCION_DOCUMENTO", nullable = true, length = 8)
	private String descripcionDocumento;
	
	private String fechaenchar;

	public String getUnidadregistro() {
		return unidadregistro;
	}

	public void setUnidadregistro(String unidadregistro) {
		this.unidadregistro = unidadregistro;
	}

	public Documento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(Long documentoId) {
		this.documentoId = documentoId;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Clasificacion getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTipoOrganizacion() {
		return tipoOrganizacion;
	}

	public void setTipoOrganizacion(String tipoOrganizacion) {
		this.tipoOrganizacion = tipoOrganizacion;
	}

//	public Date getFechaDocumento() {
//		return fechaDocumento;
//	}
//
//	public void setFechaDocumento(Date fechaDocumento) {
//		this.fechaDocumento = fechaDocumento;
//	}

	
	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public String getFechaDocumento() {
		return fechaDocumento;
	}

	public void setFechaDocumento(String fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public String getDocumentoReferencia() {
		return documentoReferencia;
	}

	public void setDocumentoReferencia(String documentoReferencia) {
		this.documentoReferencia = documentoReferencia;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public TipoEstado getTipoEstado() {
		return tipoEstado;
	}

	public void setTipoEstado(TipoEstado tipoEstado) {
		this.tipoEstado = tipoEstado;
	}

	

	public String getNucleoRemitente() {
		return nucleoRemitente;
	}

	public void setNucleoRemitente(String nucleoRemitente) {
		this.nucleoRemitente = nucleoRemitente;
	}

	public String getBrigadaRemitente() {
		return brigadaRemitente;
	}

	public void setBrigadaRemitente(String brigadaRemitente) {
		this.brigadaRemitente = brigadaRemitente;
	}

	public String getUnidadRemitente() {
		return unidadRemitente;
	}

	public void setUnidadRemitente(String unidadRemitente) {
		this.unidadRemitente = unidadRemitente;
	}

	public String getNucleoResponsable() {
		return nucleoResponsable;
	}

	public void setNucleoResponsable(String nucleoResponsable) {
		this.nucleoResponsable = nucleoResponsable;
	}

	public String getBrigadaResponsable() {
		return brigadaResponsable;
	}

	public void setBrigadaResponsable(String brigadaResponsable) {
		this.brigadaResponsable = brigadaResponsable;
	}

	public String getUnidadResponsable() {
		return unidadResponsable;
	}

	public void setUnidadResponsable(String unidadResponsable) {
		this.unidadResponsable = unidadResponsable;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public String getUsuarioActualizacion() {
		return usuarioActualizacion;
	}

	public void setUsuarioActualizacion(String usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}

	public String getUsuarioEliminacion() {
		return usuarioEliminacion;
	}

	public void setUsuarioEliminacion(String usuarioEliminacion) {
		this.usuarioEliminacion = usuarioEliminacion;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Integer getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(Integer estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getDescripcionDocumento() {
		return descripcionDocumento;
	}

	public void setDescripcionDocumento(String descripcionDocumento) {
		this.descripcionDocumento = descripcionDocumento;
	}

	public String getFechaenchar() {
		return fechaenchar;
	}

	public void setFechaenchar(String fechaenchar) {
		this.fechaenchar = fechaenchar;
	}

	@Override
	public String toString() {
		return "Documento [documentoId=" + documentoId + ", anio=" + anio + ", unidadregistro=" + unidadregistro
				+ ", tipoDocumento=" + tipoDocumento + ", clasificacion=" + clasificacion + ", numeroDocumento="
				+ numeroDocumento + ", tipoOrganizacion=" + tipoOrganizacion + ", fechaDocumento=" + fechaDocumento
				+ ", fechaRecepcion=" + fechaRecepcion + ", documentoReferencia=" + documentoReferencia + ", asunto="
				+ asunto + ", tipoEstado=" + tipoEstado + ", nucleoRemitente=" + nucleoRemitente + ", brigadaRemitente="
				+ brigadaRemitente + ", unidadRemitente=" + unidadRemitente + ", nucleoResponsable=" + nucleoResponsable
				+ ", brigadaResponsable=" + brigadaResponsable + ", unidadResponsable=" + unidadResponsable
				+ ", archivo=" + archivo + ", usuarioRegistro=" + usuarioRegistro + ", usuarioActualizacion="
				+ usuarioActualizacion + ", usuarioEliminacion=" + usuarioEliminacion + ", respuesta=" + respuesta
				+ ", estadoRegistro=" + estadoRegistro + ", descripcionDocumento=" + descripcionDocumento + "]";
	}

	

	
	
}