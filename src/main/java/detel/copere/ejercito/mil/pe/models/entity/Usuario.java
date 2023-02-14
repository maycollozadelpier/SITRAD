package detel.copere.ejercito.mil.pe.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SITRAD_USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_usuario")
	@SequenceGenerator(name = "seq_id_usuario", allocationSize = 1, sequenceName = "seq_id_usuario")
	@Column(name = "NID_USUARIO", nullable = false)
	private Long usuarioId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "NID_PERSONA", referencedColumnName = "NID_PERSONA", nullable = false)
	private Persona persona;

	@Column(name = "VUSERNAME_USUARIO", nullable = false)
	private String username;

	@Column(name = "VPASSWORD_USUARIO",  nullable = false)
	private String password;

	@Column(name = "VDIVISION_USUARIO", length = 2,nullable = true)
	private String division;

	@Column(name = "VGRAN_UNIDAD_USUARIO", length = 4, nullable = true)
	private String granUnidad;

	@Column(name = "VUNIDAD_USUARIO", length = 6,nullable = true)
	private String unidad;

	@Column(name = "NESTADO_REGISTRO", nullable = false)
	private Integer estadoRegistro;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "NID_PERFIL", referencedColumnName = "NID_PERFIL", nullable = false)
	private Perfil perfil;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(Long usuarioId, detel.copere.ejercito.mil.pe.models.entity.Persona persona, String username,
			String password, String division, String granUnidad, String unidad, Integer estadoRegistro,
			detel.copere.ejercito.mil.pe.models.entity.Perfil perfil) {
		super();
		this.usuarioId = usuarioId;
		this.persona = persona;
		this.username = username;
		this.password = password;
		this.division = division;
		this.granUnidad = granUnidad;
		this.unidad = unidad;
		this.estadoRegistro = estadoRegistro;
		this.perfil = perfil;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getGranUnidad() {
		return granUnidad;
	}

	public void setGranUnidad(String granUnidad) {
		this.granUnidad = granUnidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public Integer getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(Integer estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Usuario [usuarioId=" + usuarioId + ", persona=" + persona + ", username=" + username + ", password="
				+ password + ", division=" + division + ", granUnidad=" + granUnidad + ", unidad=" + unidad
				+ ", estadoRegistro=" + estadoRegistro + ", perfil=" + perfil + "]";
	}
	
	
}
