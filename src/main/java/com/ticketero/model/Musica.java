package com.ticketero.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="musica")
public class Musica {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	public void setEstilo(String est) {
		this.estilo = est;
	}
	
	public static Builder getBuilder() {
        return new Builder();
    }
	
	public static class Builder {

        private Musica built;

        public Builder() {
        	built = new Musica();
        }
        
        public Builder(String estilo) {
            built = new Musica();
            built.estilo = estilo;
        }

        public Musica build() {
            return built;
        }

        public Builder nombre(String est) {
            built.estilo = est;
            return this;
        }
    }
	
	 public void update(String es) {
        this.estilo= es;
	 }

}