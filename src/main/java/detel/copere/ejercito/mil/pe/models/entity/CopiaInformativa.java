package detel.copere.ejercito.mil.pe.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SITRAD_COPIA_INFORMATIVA")
public class CopiaInformativa {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_unidad_doc_registra")
	@SequenceGenerator(name = "seq_unidad_doc_registra", sequenceName = "seq_unidad_doc_registra", allocationSize = 1)
	@Column(name = "COD_COPIA_INFORMATIVA")
	private Integer idCopiaInformativa;

	 
	@Column(name = "NID_DOCUMENTO", length = 8, nullable = false)
	private String idDocumento;

	@Column(name = "VCOD_UNIDAD_COPIA_INFORMATIVA", length = 8, nullable = true)
	private String codUnidadCopiaInformativa;
	
	@Column(name = "VCOD_TIPO_ESTADO", length = 1, nullable = true)
	private String estado;
	
	@Column(name = "UNIDADCOMEN",  nullable = true)
	private String unidadcoment;

	
	public CopiaInformativa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdCopiaInformativa() {
		return idCopiaInformativa;
	}

	public void setIdCopiaInformativa(Integer idCopiaInformativa) {
		this.idCopiaInformativa = idCopiaInformativa;
	}

	public String getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getCodUnidadCopiaInformativa() {
		return codUnidadCopiaInformativa;
	}

	public void setCodUnidadCopiaInformativa(String codUnidadCopiaInformativa) {
		this.codUnidadCopiaInformativa = codUnidadCopiaInformativa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUnidadcoment() {
		return unidadcoment;
	}

	public void setUnidadcoment(String unidadcoment) {
		this.unidadcoment = unidadcoment;
	}

	@Override
	public String toString() {
		return "CopiaInformativa [idCopiaInformativa=" + idCopiaInformativa + ", idDocumento=" + idDocumento
				+ ", codUnidadCopiaInformativa=" + codUnidadCopiaInformativa + ", estado=" + estado + ", unidadcoment="
				+ unidadcoment + "]";
	}

	
	


}
