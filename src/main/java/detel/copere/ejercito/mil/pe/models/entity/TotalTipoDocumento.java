package detel.copere.ejercito.mil.pe.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "SITRAD_TOTAL_TIPO_DOCUMENTO")
@Immutable
public class TotalTipoDocumento implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	VUNIDAD_CODIGO_RESP
	
	@Column(name = "VUNIDAD_CODIGO_RESP", columnDefinition = "NUMBER(15)")
	private String codUnidad;

//	VID_TIPO_DOC
	@Id
	@Column(name = "VID_TIPO_DOC")
	private String idTipoDoc;
	   
//	VDESCRIPCION_DOC
	@Column(name = "VDESCRIPCION_DOC")
	private String acronimoDoc;
	
//	TOTAL_DOC
	@Column(name = "TOTAL_DOC", columnDefinition = "NUMBER()")
	private String totalDoc;

	public TotalTipoDocumento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TotalTipoDocumento(String codUnidad, String idTipoDoc, String acronimoDoc, String totalDoc) {
		super();
		this.codUnidad = codUnidad;
		this.idTipoDoc = idTipoDoc;
		this.acronimoDoc = acronimoDoc;
		this.totalDoc = totalDoc;
	}

	public String getCodUnidad() {
		return codUnidad;
	}

	public void setCodUnidad(String codUnidad) {
		this.codUnidad = codUnidad;
	}

	public String getIdTipoDoc() {
		return idTipoDoc;
	}

	public void setIdTipoDoc(String idTipoDoc) {
		this.idTipoDoc = idTipoDoc;
	}

	public String getAcronimoDoc() {
		return acronimoDoc;
	}

	public void setAcronimoDoc(String acronimoDoc) {
		this.acronimoDoc = acronimoDoc;
	}

	public String getTotalDoc() {
		return totalDoc;
	}

	public void setTotalDoc(String totalDoc) {
		this.totalDoc = totalDoc;
	}

	@Override
	public String toString() {
		return "TotalTipoDocumento [codUnidad=" + codUnidad + ", idTipoDoc=" + idTipoDoc + ", acronimoDoc="
				+ acronimoDoc + ", totalDoc=" + totalDoc + "]";
	}
	
	
}
