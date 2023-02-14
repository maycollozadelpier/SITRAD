package detel.copere.ejercito.mil.pe.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SITRAD_NUCLEO")
public class Nucleo {
	
	@Id
	@Column(name = "VCOD_NUCLEO", length = 2, nullable = false)
	private String nucleoCodigo;

	@Column(name = "VDESCRIPCION_NUCLEO", length = 200, nullable = false)
	private String nucleoDescripcion;

	@Column(name = "NESTADO_REGISTRO", length = 1, nullable = false)
	private Integer estadoRegistro;

	@Column(name = "VABREV_NUCLEO", length = 20, nullable = false)
	private String nucleoAbreviatura;

	public Nucleo() {

	}

	public String getNucleoCodigo() {
		return nucleoCodigo;
	}

	public void setNucleoCodigo(String nucleoCodigo) {
		this.nucleoCodigo = nucleoCodigo;
	}

	public String getNucleoDescripcion() {
		return nucleoDescripcion;
	}

	public void setNucleoDescripcion(String nucleoDescripcion) {
		this.nucleoDescripcion = nucleoDescripcion;
	}

	public Integer getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(Integer estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getNucleoAbreviatura() {
		return nucleoAbreviatura;
	}

	public void setNucleoAbreviatura(String nucleoAbreviatura) {
		this.nucleoAbreviatura = nucleoAbreviatura;
	}

	@Override
	public String toString() {
		return "Nucleo [nucleoCodigo=" + nucleoCodigo + ", nucleoDescripcion=" + nucleoDescripcion + ", estadoRegistro="
				+ estadoRegistro + ", nucleoAbreviatura=" + nucleoAbreviatura + "]";
	}

}
