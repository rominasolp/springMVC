package com.ticketero.dto;

import java.io.Serializable;

public class DeporteDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer evento_id;
	private String deporte;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	public Integer getEvento_id() {
		return evento_id;
	}
	public void setEvento_id(Integer evento_id) {
		this.evento_id = evento_id;
	}
	
}
