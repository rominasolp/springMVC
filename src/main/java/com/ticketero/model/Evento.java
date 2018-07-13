package com.ticketero.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="evento")
public class Evento {

	@Id
	//@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nombre_evento;
	private Double precio;
	private String descripcion;
	private Integer stock;
	private Date fecha_desde;
	private Date fecha_hasta;
	private String direccion;
	
	//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Integer tipo_de_evento;

	public String getNombreEvento() {
		return nombre_evento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombre_evento = nombreEvento;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Date getFechaDesde() {
		return fecha_desde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fecha_desde = fechaDesde;
	}

	public Date getFechaHasta() {
		return fecha_hasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fecha_hasta = fechaHasta;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdTipoDeEvento() {
		return tipo_de_evento;
	}

	public void setIdTipoDeEvento(Integer idTipoDeEvento) {
		this.tipo_de_evento = idTipoDeEvento;
	}

	
	
	public static Builder getBuilder() {
        return new Builder();
    }
	
	public static class Builder {

        private Evento built;

        public Builder() {
        	built = new Evento();
        }
        
        public Builder(String nom) {
            built = new Evento();
            built.nombre_evento = nom;
        }

        public Evento build() {
            return built;
        }

        public Builder nombre(String nom) {
            built.nombre_evento = nom;
            return this;
        }
    }
	
	 public void update(String nom, 
			 String desc, String dir, 
			 Date fdesde, Date fhasta,
			 double precio,	Integer stk,
			 Integer eventoId) {
        this.nombre_evento= nom;
        this.descripcion = desc;
        this.direccion = dir;
        this.fecha_desde = fdesde;
        this.fecha_hasta = fhasta;
        this.precio = precio;
        this.stock = stk;
        this.tipo_de_evento = eventoId;
        
	 }	
	 
}
