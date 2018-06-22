package com.ticketero.service;

import java.util.List;

import com.ticketero.model.Cliente;

public interface ClienteService {

	public void addCliente(Cliente p);
	public void updateCliente(Cliente p);
	public List<Cliente> listClientes();
	public Cliente getClienteById(int id);
	public void removeCliente(int id);
	
}
