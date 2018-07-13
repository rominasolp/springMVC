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
	private Integer id;

	private Integer evento_id;
	private String genero;
	
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
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public static Builder getBuilder() {
        return new Builder();
    }
	
	public static class Builder {

        private Teatro built;

        public Builder() {
        	built = new Teatro();
        }
        
        public Builder(String nom) {
            built = new Teatro();
            built.genero = nom;
        }

        public Teatro build() {
            return built;
        }

        public Builder nombre(String nom) {
            built.genero = nom;
            return this;
        }
    }
	
	 public void update(String nom) {
        this.genero= nom;
	 }

}