package com.ticketero.dao;

import java.util.List;

import com.ticketero.model.Cliente;

public interface ClienteDAO {

	public void addCliente(Cliente p);
	public void updateCliente(Cliente p);
	public List<Cliente> listClientes();
	public Cliente getClienteById(int id);
	public void removeCliente(int id);
}
