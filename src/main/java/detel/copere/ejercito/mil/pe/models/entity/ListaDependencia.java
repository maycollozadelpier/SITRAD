package detel.copere.ejercito.mil.pe.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "SITRAD_LISTA_DEPENDENCIAS")
@Immutable
public class ListaDependencia implements Serializable {

//	UU_CODIGO
	@Id
	@Column(name = "UU_CODIGO")
	private String codigoUnidad;

//	UU_DESCCRIPCION
	@Column(name = "UU_DESCRIPCION")
	private String descripcionUnidad;

	public ListaDependencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListaDependencia(String codigoUnidad, String descripcionUnidad) {
		super();
		this.codigoUnidad = codigoUnidad;
		this.descripcionUnidad = descripcionUnidad;
	}

	public String getCodigoUnidad() {
		return codigoUnidad;
	}

	public void setCodigoUnidad(String codigoUnidad) {
		this.codigoUnidad = codigoUnidad;
	}

	public String getDescripcionUnidad() {
		return descripcionUnidad;
	}

	public void setDescripcionUnidad(String descripcionUnidad) {
		this.descripcionUnidad = descripcionUnidad;
	}

	@Override
	public String toString() {
		return "ListaDependencia [codigoUnidad=" + codigoUnidad + ", descripcionUnidad=" + descripcionUnidad + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
