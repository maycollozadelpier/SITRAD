package detel.copere.ejercito.mil.pe.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SITRAD_PERFIL")
public class Perfil {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PERFIL_ID")
	@SequenceGenerator(name = "SEQ_PERFIL_ID", allocationSize = 1, sequenceName = "SEQ_PERFIL_ID")
	@Column(name = "NID_PERFIL", nullable = false)
	private Long perfilId;

	@Column(name = "VNOMBRE_PERFIL", nullable = false)
	private String nombre;

	@Column(name = "VDESCRIPCION_PERFIL", nullable = true)
	private String descripcion;

	@Column(name = "NESTADO_REGISTRO", nullable = false)
	private Integer estadoRegistro;

	public Perfil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Perfil(Long perfilId, String nombre, String descripcion, Integer estadoRegistro) {
		super();
		this.perfilId = perfilId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estadoRegistro = estadoRegistro;
	}

	public Long getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(Long perfilId) {
		this.perfilId = perfilId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(Integer estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	@Override
	public String toString() {
		return "Perfil [perfilId=" + perfilId + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", estadoRegistro=" + estadoRegistro + "]";
	}
	
}
