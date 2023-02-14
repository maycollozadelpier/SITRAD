package detel.copere.ejercito.mil.pe.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SITRAD_DISTRIBUCION_DOCUMENTO")
public class DistribucionDocumento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_distribucion_cod")
	@SequenceGenerator(name = "seq_distribucion_cod", sequenceName = "seq_distribucion_cod", allocationSize = 1)
	@Column(name = "COD_DISTRIBUCION")
	private Integer distribucionCodigo;
	
	@Column(name = "NID_DOCUMENTO", length = 8, nullable = false)
	private String idDocumento;

	@Column(name = "ID_DISTRIBUCION", length = 8, nullable = true)
	private String idDistribucion;

	

	public DistribucionDocumento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getDistribucionCodigo() {
		return distribucionCodigo;
	}

	public void setDistribucionCodigo(Integer distribucionCodigo) {
		this.distribucionCodigo = distribucionCodigo;
	}

	public String getIdDocume() {
		return idDocumento;
	}

	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getIdDistribucion() {
		return idDistribucion;
	}

	public void setIdDistribucion(String idDistribucion) {
		this.idDistribucion = idDistribucion;
	}

	@Override
	public String toString() {
		return "DistribucionDocumento [distribucionCodigo=" + distribucionCodigo + ", idDocumento=" + idDocumento
				+ ", idDistribucion=" + idDistribucion + "]";
	}


}
