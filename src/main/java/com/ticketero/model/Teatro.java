package com.ticketero.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teatro")
public class Teatro {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int evento_id;
	private String genero;
	
	public int getEvento_id() {
		return evento_id;
	}
	public void setEvento_id(int evento_id) {
		this.evento_id = evento_id;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String gen) {
		this.genero = gen;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
