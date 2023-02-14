package detel.copere.ejercito.mil.pe.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "SITRAD_DETALLE_DEPENDENCIAS")
@Immutable
public class DetalleDependencia implements Serializable {

//	UU_CODIGO
	@Id
	@Column(name = "UU_CODIGO")
	private String codigoUnidad;

//	UU_DESCCRIPCION
	@Column(name = "UU_DESCRIPCION")
	private String descripcionUnidad;

//	UNIDAD_REMITIDOS
	@Column(name = "UNIDAD")
	private String tipUnidad;

//	PENDIENTES
	@Column(name = "PENDIENTES")
	private String pendientes;

//	REMITIDOS
	@Column(name = "REMITIDOS")
	private String remitidos;

//	RESPONDIDO
	@Column(name = "RESPONDIDO")
	private String respondido;

//	DECRETADO
	@Column(name = "DECRETADO")
	private String decretado;

//	ARCHIVADO
	@Column(name = "ARCHIVADO")
	private String archivado;
	
	public DetalleDependencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public DetalleDependencia(String codigoUnidad, String descripcionUnidad, String tipUnidad, String pendientes,
			String remitidos, String respondido, String decretado, String archivado) {
		super();
		this.codigoUnidad = codigoUnidad;
		this.descripcionUnidad = descripcionUnidad;
		this.tipUnidad = tipUnidad;
		this.pendientes = pendientes;
		this.remitidos = remitidos;
		this.respondido = respondido;
		this.decretado = decretado;
		this.archivado = archivado;
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

	public String getTipUnidad() {
		return tipUnidad;
	}

	public void setTipUnidad(String tipUnidad) {
		this.tipUnidad = tipUnidad;
	}

	public String getPendientes() {
		return pendientes;
	}

	public void setPendientes(String pendientes) {
		this.pendientes = pendientes;
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

	public String getArchivado() {
		return archivado;
	}

	public void setArchivado(String archivado) {
		this.archivado = archivado;
	}

	


	@Override
	public String toString() {
		return "DetalleDependencia [codigoUnidad=" + codigoUnidad + ", descripcionUnidad=" + descripcionUnidad
				+ ", tipUnidad=" + tipUnidad + ", pendientes=" + pendientes + ", remitidos=" + remitidos
				+ ", respondido=" + respondido + ", decretado=" + decretado + ", archivado=" + archivado + "]";
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
