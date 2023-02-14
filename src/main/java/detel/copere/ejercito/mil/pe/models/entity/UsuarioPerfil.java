package detel.copere.ejercito.mil.pe.models.entity;

import java.io.Serializable;



public class UsuarioPerfil implements Serializable {

	// atributos de la tabla persona
	private Long personaId;
	private String numeroDocumento;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String foto;
	private String correo;
	private String celular;
	private Integer estadoRegistro;

	// atributos de la tabla usuario
	private Long usuarioId;
	private String username;
	private String password;
	private String division;
	private String granUnidad;
	private String unidad;
	private Long perfil;
	
	

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

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
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

	public Long getPerfil() {
		return perfil;
	}

	public void setPerfil(Long perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "UsuarioPerfil [personaId=" + personaId + ", numeroDocumento=" + numeroDocumento + ", nombres=" + nombres
				+ ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", foto=" + foto
				+ ", correo=" + correo + ", celular=" + celular + ", estadoRegistro=" + estadoRegistro + ", usuarioId="
				+ usuarioId + ", username=" + username + ", password=" + password + ", division=" + division
				+ ", granUnidad=" + granUnidad + ", unidad=" + unidad + ", perfil=" + perfil + "]";
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
