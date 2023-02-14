package detel.copere.ejercito.mil.pe.models.entity;

import java.io.Serializable;

public class ListasNative implements Serializable {

	private String idDocumento;
	private String numDoc;
	private String anio;
	private String idTipoOrganizacion;
	private String idTipoDoc;
	private String descripTipoDoc;
	private String idClasificacion;
	private String descripClasificacion;
	private String idTipoEstado;
	private String descripEstado;
	private String asunto;
	private String docReferencia;
	private String estadoRegistro;
	private String archivo;
	private String fDocumento;
	private String fRegDocumento;
	private String idDistribucionDoc;
	private String descripDistribucionDoc;
	private String idUnidadResponsable;
	private String unidadResponsable;
	private String idUnidadRemitente;
	private String unidadRemitente;
	private String comentario;
	private String prioridad;
	private String decreto;
	private int iddomentario;
	

	public int getIddomentario() {
		return iddomentario;
	}

	public void setIddomentario(int iddomentario) {
		this.iddomentario = iddomentario;
	}

	public String getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public String getIdTipoDoc() {
		return idTipoDoc;
	}

	public void setIdTipoDoc(String idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}

	public String getDescripTipoDoc() {
		return descripTipoDoc;
	}

	public void setDescripTipoDoc(String descripTipoDoc) {
		this.descripTipoDoc = descripTipoDoc;
	}

	public String getIdClasificacion() {
		return idClasificacion;
	}

	public void setIdClasificacion(String idClasificacion) {
		this.idClasificacion = idClasificacion;
	}

	public String getDescripClasificacion() {
		return descripClasificacion;
	}

	public void setDescripClasificacion(String descripClasificacion) {
		this.descripClasificacion = descripClasificacion;
	}

	public String getIdTipoEstado() {
		return idTipoEstado;
	}

	public void setIdTipoEstado(String idTipoEstado) {
		this.idTipoEstado = idTipoEstado;
	}

	public String getDescripEstado() {
		return descripEstado;
	}

	public void setDescripEstado(String descripEstado) {
		this.descripEstado = descripEstado;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getfDocumento() {
		return fDocumento;
	}

	public void setfDocumento(String fDocumento) {
		this.fDocumento = fDocumento;
	}

	public String getfRegDocumento() {
		return fRegDocumento;
	}

	public void setfRegDocumento(String fRegDocumento) {
		this.fRegDocumento = fRegDocumento;
	}

	public String getIdDistribucionDoc() {
		return idDistribucionDoc;
	}

	public void setIdDistribucionDoc(String idDistribucionDoc) {
		this.idDistribucionDoc = idDistribucionDoc;
	}

	public String getDescripDistribucionDoc() {
		return descripDistribucionDoc;
	}

	public void setDescripDistribucionDoc(String descripDistribucionDoc) {
		this.descripDistribucionDoc = descripDistribucionDoc;
	}

	public String getIdUnidadResponsable() {
		return idUnidadResponsable;
	}

	public void setIdUnidadResponsable(String idUnidadResponsable) {
		this.idUnidadResponsable = idUnidadResponsable;
	}

	public String getIdUnidadRemitente() {
		return idUnidadRemitente;
	}

	public void setIdUnidadRemitente(String idUnidadRemitente) {
		this.idUnidadRemitente = idUnidadRemitente;
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

	
	
	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getIdTipoOrganizacion() {
		return idTipoOrganizacion;
	}

	public void setIdTipoOrganizacion(String idTipoOrganizacion) {
		this.idTipoOrganizacion = idTipoOrganizacion;
	}

	public String getDocReferencia() {
		return docReferencia;
	}

	public void setDocReferencia(String docReferencia) {
		this.docReferencia = docReferencia;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	
	public String getUnidadResponsable() {
		return unidadResponsable;
	}

	public void setUnidadResponsable(String unidadResponsable) {
		this.unidadResponsable = unidadResponsable;
	}

	public String getUnidadRemitente() {
		return unidadRemitente;
	}

	public void setUnidadRemitente(String unidadRemitente) {
		this.unidadRemitente = unidadRemitente;
	}

	
	public String getDecreto() {
		return decreto;
	}

	public void setDecreto(String decreto) {
		this.decreto = decreto;
	}


	@Override
	public String toString() {
		return "ListasNative [idDocumento=" + idDocumento + ", numDoc=" + numDoc + ", anio=" + anio
				+ ", idTipoOrganizacion=" + idTipoOrganizacion + ", idTipoDoc=" + idTipoDoc + ", descripTipoDoc="
				+ descripTipoDoc + ", idClasificacion=" + idClasificacion + ", descripClasificacion="
				+ descripClasificacion + ", idTipoEstado=" + idTipoEstado + ", descripEstado=" + descripEstado
				+ ", asunto=" + asunto + ", docReferencia=" + docReferencia + ", estadoRegistro=" + estadoRegistro
				+ ", archivo=" + archivo + ", fDocumento=" + fDocumento + ", fRegDocumento=" + fRegDocumento
				+ ", idDistribucionDoc=" + idDistribucionDoc + ", descripDistribucionDoc=" + descripDistribucionDoc
				+ ", idUnidadResponsable=" + idUnidadResponsable + ", unidadResponsable=" + unidadResponsable
				+ ", idUnidadRemitente=" + idUnidadRemitente + ", unidadRemitente=" + unidadRemitente + ", comentario="
				+ comentario + ", prioridad=" + prioridad + ", decreto=" + decreto + ", iddomentario=" + iddomentario
				+ "]";
	}







	private static final long serialVersionUID = 1L;

}
