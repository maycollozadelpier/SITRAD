package detel.copere.ejercito.mil.pe.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "SITRAD_TOTAL_TIPO_DOC_REMITIDO")
@Immutable
public class TotalTipoDocRemitido implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

//	VUNIDAD_CODIGO_REMIT

	@Column(name = "VUNIDAD_CODIGO_REMIT", columnDefinition = "NUMBER(15)")
	private String codUnidadRemi;

//	VID_TIPO_DOC
	@Id
	@Column(name = "VID_TIPO_DOC")
	private String idTipoDocu;

//	VDESCRIPCION_DOC
	@Column(name = "VDESCRIPCION_DOC")
	private String acronimo;

//	TOTAL_DOC
	@Column(name = "TOTAL_DOC", columnDefinition = "NUMBER()")
	private String total;

	public TotalTipoDocRemitido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TotalTipoDocRemitido(String codUnidadRemi, String idTipoDocu, String acronimo, String total) {
		super();
		this.codUnidadRemi = codUnidadRemi;
		this.idTipoDocu = idTipoDocu;
		this.acronimo = acronimo;
		this.total = total;
	}

	public String getCodUnidadRemi() {
		return codUnidadRemi;
	}

	public void setCodUnidadRemi(String codUnidadRemi) {
		this.codUnidadRemi = codUnidadRemi;
	}

	public String getIdTipoDocu() {
		return idTipoDocu;
	}

	public void setIdTipoDocu(String idTipoDocu) {
		this.idTipoDocu = idTipoDocu;
	}

	public String getAcronimo() {
		return acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "TotalTipoDocRemitido [codUnidadRemi=" + codUnidadRemi + ", idTipoDocu=" + idTipoDocu + ", acronimo="
				+ acronimo + ", total=" + total + "]";
	}

}
