package detel.copere.ejercito.mil.pe.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SITRAD_COMENTARIO_DOCUMENTO")
public class ComentarioDocumento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_comentario_id")
	@SequenceGenerator(name = "seq_comentario_id", sequenceName = "seq_comentario_id", allocationSize = 1)
	@Column(name = "COD_COMENTARIO_DOCUEMENTO")
	private Integer idCoemntarioDocumento;
	
	@Column(name = "NID_DOCUMENTO", length = 8, nullable = false)
	private String idDocumento;
 
	@Column(name = "COMENTARIO", length = 500, nullable = true)
	private String comentario;
	
	@Column(name = "PRIORIDAD", length = 1, nullable = true)
	private String prioridad;
	
	

	public ComentarioDocumento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdCoemntarioDocumento() {
		return idCoemntarioDocumento;
	}

	public void setIdCoemntarioDocumento(Integer idCoemntarioDocumento) {
		this.idCoemntarioDocumento = idCoemntarioDocumento;
	}

	public String getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	@Override
	public String toString() {
		return "ComentarioDocumento [idCoemntarioDocumento=" + idCoemntarioDocumento + ", idDocumento=" + idDocumento
				+ ", comentario=" + comentario + ", prioridad=" + prioridad + "]";
	}

	
}
