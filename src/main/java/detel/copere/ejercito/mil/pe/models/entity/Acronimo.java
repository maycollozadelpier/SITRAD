package detel.copere.ejercito.mil.pe.models.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SITRAD_ACRONIMO")
public class Acronimo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idacronimo")
	private Long idacronimo;
	@Column(name = "descripcionacronimo", columnDefinition = "varchar(50)")
	private String descripcionacronimo;
	
	private Long NID_DOCUMENTO;

	public Long getIdacronimo() {
		return idacronimo;
	}

	public void setIdacronimo(Long idacronimo) {
		this.idacronimo = idacronimo;
	}

	public String getDescripcionacronimo() {
		return descripcionacronimo;
	}

	public void setDescripcionacronimo(String descripcionacronimo) {
		this.descripcionacronimo = descripcionacronimo;
	}

	public Long getNID_DOCUMENTO() {
		return NID_DOCUMENTO;
	}

	public void setNID_DOCUMENTO(Long nID_DOCUMENTO) {
		NID_DOCUMENTO = nID_DOCUMENTO;
	}

	@Override
	public String toString() {
		return "Acronimo [idacronimo=" + idacronimo + ", descripcionacronimo=" + descripcionacronimo
				+ ", NID_DOCUMENTO=" + NID_DOCUMENTO + "]";
	}
	
	
}
