package com.ticketero.service;

import java.util.List;

import com.ticketero.model.Cliente;
import com.ticketero.dto.ClienteDto;
import com.ticketero.exception.ClienteNotFoundException;

public interface IClienteService {

	public Cliente addCliente(ClienteDto p);
	public Cliente updateCliente(ClienteDto p) throws ClienteNotFoundException;
	public List<Cliente> listClientes();
	public Cliente getClienteById(int id) throws ClienteNotFoundException;
	public Cliente removeCliente(int id)throws ClienteNotFoundException;
	public Boolean isValidUser(String nombre, String password);
	
}
