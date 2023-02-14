package detel.copere.ejercito.mil.pe.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "SITRAD_DETALLE_REMITENTES")
@Immutable
public class DetalleRemitentes implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	// UU_CODIGO_REMI
	@Id
	@Column(name = "UU_CODIGO_REMI")
	private String codigoUnidadRemi;

//	UU_DESCRIPCION_REMI
	@Column(name = "UU_DESCRIPCION_REMI")
	private String descripcionUnidadRemi;

//	REMITIDOS
	@Column(name = "REMITIDOS")
	private String remitidos;

//	RESPONDIDO
	@Column(name = "RESPONDIDO")
	private String respondido;

//	DECRETADO
	@Column(name = "DECRETADO")
	private String decretado;

	public DetalleRemitentes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetalleRemitentes(String codigoUnidadRemi, String descripcionUnidadRemi, String remitidos, String respondido,
			String decretado) {
		super();
		this.codigoUnidadRemi = codigoUnidadRemi;
		this.descripcionUnidadRemi = descripcionUnidadRemi;
		this.remitidos = remitidos;
		this.respondido = respondido;
		this.decretado = decretado;
	}

	public String getCodigoUnidadRemi() {
		return codigoUnidadRemi;
	}

	public void setCodigoUnidadRemi(String codigoUnidadRemi) {
		this.codigoUnidadRemi = codigoUnidadRemi;
	}

	public String getDescripcionUnidadRemi() {
		return descripcionUnidadRemi;
	}

	public void setDescripcionUnidadRemi(String descripcionUnidadRemi) {
		this.descripcionUnidadRemi = descripcionUnidadRemi;
	}

	public String getRemitidos() {
		return remitidos;
	}

	public void setRemitidos(String remitidos) {
		this.remitidos = remitidos;
	}

	public String getRespondido() {
		return respondido;
	}

	public void setRespondido(String respondido) {
		this.respondido = respondido;
	}

	public String getDecretado() {
		return decretado;
	}

	public void setDecretado(String decretado) {
		this.decretado = decretado;
	}

	@Override
	public String toString() {
		return "DetalleRemitentes [codigoUnidadRemi=" + codigoUnidadRemi + ", descripcionUnidadRemi="
				+ descripcionUnidadRemi + ", remitidos=" + remitidos + ", respondido=" + respondido + ", decretado="
				+ decretado + "]";
	}

}
