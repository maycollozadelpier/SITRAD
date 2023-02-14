package detel.copere.ejercito.mil.pe.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SITRAD_GGUU")
public class Brigada {
	
	@Id
	@Column(name = "VCOD_ACTIVIDAD", length = 4, nullable = false)
	private String brigadaCodigo;

	@Column(name = "VDESCRIPCION_ACTIVIDAD", length = 300, nullable = false)
	private String brigadaDescripcion;
	
	@Column(name = "VCOD_NUCLEO", length = 2, nullable = false)
	private String nucleoCodigo;

	@Column(name = "NESTADO_REGISTRO", length = 1, nullable = false)
	private Integer estadoRegistro;

	@Column(name = "VABREV_ACTIVIDAD", length = 30, nullable = false)
	private String brigadabreviatura;

	
	public Brigada() {
	}


	public String getBrigadaCodigo() {
		return brigadaCodigo;
	}


	public void setBrigadaCodigo(String brigadaCodigo) {
		this.brigadaCodigo = brigadaCodigo;
	}


	public String getBrigadaDescripcion() {
		return brigadaDescripcion;
	}


	public void setBrigadaDescripcion(String brigadaDescripcion) {
		this.brigadaDescripcion = brigadaDescripcion;
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


	public String getBrigadabreviatura() {
		return brigadabreviatura;
	}


	public void setBrigadabreviatura(String brigadabreviatura) {
		this.brigadabreviatura = brigadabreviatura;
	}


	@Override
	public String toString() {
		return "Brigada [brigadaCodigo=" + brigadaCodigo + ", brigadaDescripcion=" + brigadaDescripcion
				+ ", nucleoCodigo=" + nucleoCodigo + ", estadoRegistro=" + estadoRegistro + ", brigadabreviatura="
				+ brigadabreviatura + "]";
	}

}
