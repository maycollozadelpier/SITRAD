package detel.copere.ejercito.mil.pe.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SITRAD_DOCUMENTO_REGISTRADO")
public class DocRegistrado {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_copia_informativa_id")
	@SequenceGenerator(name = "seq_copia_informativa_id", sequenceName = "seq_copia_informativa_id", allocationSize = 1)
	@Column(name = "COD_DOC_REGISTRADO")
	private Integer codDocRegistrado;

	 
	@Column(name = "NID_DOCUMENTO", length = 8, nullable = false)
	private String idDocumento;

	@Column(name = "VCOD_UNIDAD_DOC_REGISTRA", length = 8, nullable = true)
	private String codUnidadDocRegistra;
	
	@Column(name = "VCOD_TIPO_ESTADO", length = 8, nullable = true)
	private String estado;
	
	public DocRegistrado() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getCodDocRegistrado() {
		return codDocRegistrado;
	}

	public void setCodDocRegistrado(Integer codDocRegistrado) {
		this.codDocRegistrado = codDocRegistrado;
	}

	public String getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getCodUnidadDocRegistra() {
		return codUnidadDocRegistra;
	}

	public void setCodUnidadDocRegistra(String codUnidadDocRegistra) {
		this.codUnidadDocRegistra = codUnidadDocRegistra;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "DocRegistrado [codDocRegistrado=" + codDocRegistrado + ", idDocumento=" + idDocumento
				+ ", codUnidadDocRegistra=" + codUnidadDocRegistra + ", estado=" + estado + "]";
	}
	
	

}
