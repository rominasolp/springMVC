package com.ticketero.dto;

import java.io.Serializable;


public class ClienteDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;	
	private String nombre;	
	private String apellido;
	private String login;
	private String password;
	private String email;
	private String telefono;
	
	public Integer getId() {
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


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	@Override
	public String toString(){
		return "id="+id+", nombre="+nombre+", apellido="+apellido;
	}
	
}
