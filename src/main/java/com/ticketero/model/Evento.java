package com.ticketero.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="evento")
public class Evento {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nombre_evento;
	private Double precio;
	private String descripcion;
	private int stock;
	private Date fecha_desde;
	private Date fecha_hasta;
	private String direccion;
	
	
	private int tipo_de_evento;

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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdTipoDeEvento() {
		return tipo_de_evento;
	}

	public void setIdTipoDeEvento(int idTipoDeEvento) {
		this.tipo_de_evento = idTipoDeEvento;
	}

}
