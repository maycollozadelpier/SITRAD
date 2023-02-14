package detel.copere.ejercito.mil.pe.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "SITRAD_DATOSG_RLS")
@Immutable
public class DatosGenerales implements Serializable{

 
	private static final long serialVersionUID = 1L;
 
//	NID_PERSONA
	@Id
	@Column(name = "NID_PERSONA")
	private Long idPersona;
	
//	VDNI_PERSONA
	@Column(name = "VDNI_PERSONA")
	private String dni;

//	VUSERNAME_USUARIO
	@Column(name = "VUSERNAME_USUARIO")
	private String username;
	
//	NOMBRE
	@Column(name = "NOMBRE")
	private String nombre;
	
//	VEMAIL_PERSONA
	@Column(name = "VEMAIL_PERSONA")
	private String email;
	
//	NESTADO_REGISTRO
	@Column(name = "NESTADO_REGISTRO", columnDefinition = "NUMBER(10)")
	private String estado ;
	
//	VFOTO_PERSONA
	@Column(name = "VFOTO_PERSONA")
	private String foto;
	
//	VDIVISION_USUARIO
	@Column(name = "VDIVISION_USUARIO")
	private String codNucleo;
	
//	VABREV_NUCLEO
	@Column(name = "VABREV_NUCLEO")
	private String acronimoNucleo;
	
//	VGRAN_UNIDAD_USUARIO
	@Column(name = "VGRAN_UNIDAD_USUARIO")
	private String codGGUU;
	
//	VABREV_ACTIVIDAD
	@Column(name = "VABREV_ACTIVIDAD")
	private String acronimoGGUU;
	
//	VUNIDAD_USUARIO
	@Column(name = "VUNIDAD_USUARIO")
	private String codUnidad;
	
//	VABREV_UNIDAD
	@Column(name = "VABREV_UNIDAD")
	private String acronimoUnidad;

//	VGRADOS_DESCOR
	@Column(name = "VGRADOS_DESCOR")
	private String acronimoGrado;
	
//	VGRADOS_DESLAR
	@Column(name = "VGRADOS_DESLAR")
	private String acronimoGradoD;
	
//	VARMAS_DESCOR
	@Column(name = "VARMAS_DESCOR")
	private String acronimoArma;
	
//	VARMAS_DESLAR
	@Column(name = "VARMAS_DESLAR")
	private String acronimoArmaD;
	
//	VDESCRIPCION_PERFIL
	@Column(name = "VDESCRIPCION_PERFIL")
	private String perfil;
	
	
	public DatosGenerales() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getIdPersona() {
		return idPersona;
	}



	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}



	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getCodNucleo() {
		return codNucleo;
	}

	public void setCodNucleo(String codNucleo) {
		this.codNucleo = codNucleo;
	}

	public String getAcronimoNucleo() {
		return acronimoNucleo;
	}

	public void setAcronimoNucleo(String acronimoNucleo) {
		this.acronimoNucleo = acronimoNucleo;
	}

	public String getCodGGUU() {
		return codGGUU;
	}

	public void setCodGGUU(String codGGUU) {
		this.codGGUU = codGGUU;
	}

	public String getAcronimoGGUU() {
		return acronimoGGUU;
	}

	public void setAcronimoGGUU(String acronimoGGUU) {
		this.acronimoGGUU = acronimoGGUU;
	}

	public String getCodUnidad() {
		return codUnidad;
	}

	public void setCodUnidad(String codUnidad) {
		this.codUnidad = codUnidad;
	}

	public String getAcronimoUnidad() {
		return acronimoUnidad;
	}

	public void setAcronimoUnidad(String acronimoUnidad) {
		this.acronimoUnidad = acronimoUnidad;
	}

	
	public String getAcronimoGrado() {
		return acronimoGrado;
	}

	public void setAcronimoGrado(String acronimoGrado) {
		this.acronimoGrado = acronimoGrado;
	}

	public String getAcronimoArma() {
		return acronimoArma;
	}

	public void setAcronimoArma(String acronimoArma) {
		this.acronimoArma = acronimoArma;
	}
	

	public String getAcronimoGradoD() {
		return acronimoGradoD;
	}

	public void setAcronimoGradoD(String acronimoGradoD) {
		this.acronimoGradoD = acronimoGradoD;
	}

	public String getAcronimoArmaD() {
		return acronimoArmaD;
	}

	public void setAcronimoArmaD(String acronimoArmaD) {
		this.acronimoArmaD = acronimoArmaD;
	}



	@Override
	public String toString() {
		return "DatosGenerales [idPersona=" + idPersona + ", dni=" + dni + ", username=" + username + ", nombre="
				+ nombre + ", email=" + email + ", estado=" + estado + ", foto=" + foto + ", codNucleo=" + codNucleo
				+ ", acronimoNucleo=" + acronimoNucleo + ", codGGUU=" + codGGUU + ", acronimoGGUU=" + acronimoGGUU
				+ ", codUnidad=" + codUnidad + ", acronimoUnidad=" + acronimoUnidad + ", acronimoGrado=" + acronimoGrado
				+ ", acronimoGradoD=" + acronimoGradoD + ", acronimoArma=" + acronimoArma + ", acronimoArmaD="
				+ acronimoArmaD + ", perfil=" + perfil + "]";
	}

	

	

}
