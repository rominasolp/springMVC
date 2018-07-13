package com.ticketero.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipodeevento")
public class TipoDeEvento {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;		
	private String nombre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public static Builder getBuilder() {
        return new Builder();
    }
	
	public static class Builder {

        private TipoDeEvento built;

        public Builder() {
        	built = new TipoDeEvento();
        }
        
        public Builder(String nom) {
            built = new TipoDeEvento();
            built.nombre = nom;
        }

        public TipoDeEvento build() {
            return built;
        }

        public Builder nombre(String nom) {
            built.nombre = nom;
            return this;
        }
    }
	
	 public void update(String nom) {
        this.nombre= nom;
	 }
	 
}