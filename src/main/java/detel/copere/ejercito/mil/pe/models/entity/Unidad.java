package detel.copere.ejercito.mil.pe.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SITRAD_UNIDAD")
public class Unidad {
	
	@Id
	@Column(name = "VCOD_UNIDAD", length = 6, nullable = false)
	private String unidadCodigo;

	@Column(name = "VDESCRIPCION_UNIDAD", length = 300, nullable = false)
	private String unidadDescripcion;

	@Column(name = "VCOD_ACTIVIDAD", length = 4, nullable = false)
	private String brigadaCodigo;

	@Column(name = "VCOD_NUCLEO", length = 2, nullable = false)
	private String nucleoCodigo;

	@Column(name = "NESTADO_REGISTRO", length = 1, nullable = false)
	private Integer estadoRegistro;

	@Column(name = "VABREV_UNIDAD", length = 30, nullable = false)
	private String unidadAbreviatura;

	public Unidad() {

	}

	public String getUnidadCodigo() {
		return unidadCodigo;
	}

	public void setUnidadCodigo(String unidadCodigo) {
		this.unidadCodigo = unidadCodigo;
	}

	public String getUnidadDescripcion() {
		return unidadDescripcion;
	}

	public void setUnidadDescripcion(String unidadDescripcion) {
		this.unidadDescripcion = unidadDescripcion;
	}

	public String getBrigadaCodigo() {
		return brigadaCodigo;
	}

	public void setBrigadaCodigo(String brigadaCodigo) {
		this.brigadaCodigo = brigadaCodigo;
	}

	public String getNucleoCodigo() {
		return nucleoCodigo;
	}

	public void setNucleoCodigo(String nucleoCodigo) {
		this.nucleoCodigo = nucleoCodigo;
	}

	public Integer getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(Integer estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getUnidadAbreviatura() {
		return unidadAbreviatura;
	}

	public void setUnidadAbreviatura(String unidadAbreviatura) {
		this.unidadAbreviatura = unidadAbreviatura;
	}

	@Override
	public String toString() {
		return "Unidad [unidadCodigo=" + unidadCodigo + ", unidadDescripcion=" + unidadDescripcion + ", brigadaCodigo="
				+ brigadaCodigo + ", nucleoCodigo=" + nucleoCodigo + ", estadoRegistro=" + estadoRegistro
				+ ", unidadAbreviatura=" + unidadAbreviatura + "]";
	}

}
