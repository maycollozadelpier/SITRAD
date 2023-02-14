package detel.copere.ejercito.mil.pe.models.entity;

import java.io.Serializable;

public class GenericoNative implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String cod_documento;
	private String num_documento;
	private String cod_decreto;
	private String comentario;
	private String prioridad;
	private String decreto;
	
	
	public String getCod_documento() {
		return cod_documento;
	}
	public void setCod_documento(String cod_documento) {
		this.cod_documento = cod_documento;
	}
	public String getCod_decreto() {
		return cod_decreto;
	}
	public void setCod_decreto(String cod_decreto) {
		this.cod_decreto = cod_decreto;
	}
	public String getDecreto() {
		return decreto;
	}
	public void setDecreto(String decreto) {
		this.decreto = decreto;
	}
	
	
	public String getNum_documento() {
		return num_documento;
	}
	public void setNum_documento(String num_documento) {
		this.num_documento = num_documento;
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
		return "GenericoNative [cod_documento=" + cod_documento + ", num_documento=" + num_documento + ", cod_decreto="
				+ cod_decreto + ", comentario=" + comentario + ", prioridad=" + prioridad + ", decreto=" + decreto
				+ "]";
	}
	
	
	

}
