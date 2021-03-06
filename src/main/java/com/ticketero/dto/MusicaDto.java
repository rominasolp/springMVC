package com.ticketero.dto;

import java.io.Serializable;

public class MusicaDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer evento_id;
	private String estilo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEvento_id() {
		return evento_id;
	}
	public void setEvento_id(Integer evento_id) {
		this.evento_id = evento_id;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	
}
