package com.ticketero.model;

import javax.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "nombre", nullable = false, length = 60)
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
	
	/*public static Builder getBuilder(String nom) {
        return new Builder(nom);
    }*/
	public static Builder getBuilder() {
        return new Builder();
    }
	
	public static class Builder {

        private Cliente built;

        public Builder() {
        	built = new Cliente();
        }
        
        public Builder(String nom) {
            built = new Cliente();
            built.nombre = nom;
        }

        public Cliente build() {
            return built;
        }

        public Builder nombre(String nom) {
            built.nombre = nom;
            return this;
        }
    }
	
	 public void update(String nom, String ape) {
        this.nombre= nom;
        this.apellido = ape;
	 }	 

}
