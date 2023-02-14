package detel.copere.ejercito.mil.pe.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SITRAD_PERSONA")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_persona")
	@SequenceGenerator(name = "seq_id_persona", allocationSize = 1, sequenceName = "seq_id_persona")
	@Column(name = "NID_PERSONA", nullable = false)
	private Long personaId;

	@Column(name = "VDNI_PERSONA", nullable = false, length = 8)
	private String numeroDocumento;

	@Column(name = "VNOMBRE_PERSONA", nullable = false, length = 60)
	private String nombres;

	@Column(name = "VAPEPAT_PERSONA", nullable = false, length = 40)
	private String apellidoPaterno;

	@Column(name = "VAPEMAT_PERSONA", nullable = false, length = 40)
	private String apellidoMaterno;

	@Column(name = "VFOTO_PERSONA")
	private String foto;

	@Column(name = "VEMAIL_PERSONA", nullable = true)
	private String correo;

	@Column(name = "VCELULAR_PERSONA", nullable = true, length = 9)
	private String celular;

	@Column(name = "NESTADO_REGISTRO", nullable = false)
	private Integer estadoRegistro;

	public Long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Integer getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(Integer estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	@Override
	public String toString() {
		return "Persona [personaId=" + personaId + ", numeroDocumento=" + numeroDocumento + ", nombres=" + nombres
				+ ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", foto=" + foto
				+ ", correo=" + correo + ", celular=" + celular + ", estadoRegistro=" + estadoRegistro + "]";
	}

}
