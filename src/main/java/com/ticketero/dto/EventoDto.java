package com.ticketero.dto;

import java.io.Serializable;
import java.util.Date;
//import java.util.List;

public class EventoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nombre_evento;
	private double precio;
	private String descripcion;
	private Integer stock;
	private Date fecha_desde;
	private Date fecha_hasta;
	private String direccion;
	private TipoEventoDto tipo_de_evento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre_de_evento() {
		return nombre_evento;
	}
	public void setNombre_de_evento(String nombre_de_evento) {
		this.nombre_evento = nombre_de_evento;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
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
	public Date getFecha_desde() {
		return fecha_desde;
	}
	public void setFecha_desde(Date fecha_desde) {
		this.fecha_desde = fecha_desde;
	}
	public Date getFecha_hasta() {
		return fecha_hasta;
	}
	public void setFecha_hasta(Date fecha_hasta) {
		this.fecha_hasta = fecha_hasta;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public TipoEventoDto getTipo_de_evento() {
		return tipo_de_evento;
	}
	public void setTipo_de_evento(TipoEventoDto tipo_de_evento) {
		this.tipo_de_evento = tipo_de_evento;
	}
	
	
}
