package com.ticketero.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="deporte")
public class Deporte {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer evento_id;
	private String deporte;
	
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
	public String getDeporte() {
		return deporte;
	}
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	
	public static Builder getBuilder() {
        return new Builder();
    }
	
	public static class Builder {

        private Deporte built;

        public Builder() {
        	built = new Deporte();
        }
        
        public Builder(String nom) {
            built = new Deporte();
            built.deporte = nom;
        }

        public Deporte build() {
            return built;
        }

        public Builder nombre(String nom) {
            built.deporte = nom;
            return this;
        }
    }
	
	 public void update(String nom) {
        this.deporte= nom;
	 }

}