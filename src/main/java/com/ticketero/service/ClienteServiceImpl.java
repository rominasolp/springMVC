package com.ticketero.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketero.dao.ClienteDAO;
import com.ticketero.model.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private ClienteDAO ClienteDAO;

	public void setClienteDAO(ClienteDAO ClienteDAO) {
		this.ClienteDAO = ClienteDAO;
	}

	@Override
	@Transactional
	public void addCliente(Cliente p) {
		this.ClienteDAO.addCliente(p);
	}

	@Override
	@Transactional
	public void updateCliente(Cliente p) {
		this.ClienteDAO.updateCliente(p);
	}

	@Override
	@Transactional
	public List<Cliente> listClientes() {
		return this.ClienteDAO.listClientes();
	}

	@Override
	@Transactional
	public Cliente getClienteById(int id) {
		return this.ClienteDAO.getClienteById(id);
	}

	@Override
	@Transactional
	public void removeCliente(int id) {
		this.ClienteDAO.removeCliente(id);
	}

}
