package com.ticketero.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketero.dto.ClienteDto;
import com.ticketero.exception.ClienteNotFoundException;
import com.ticketero.model.Cliente;
import com.ticketero.repository.IClienteRepository;

@Service
public class ClienteService implements IClienteService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IClienteRepository.class);

    @Resource
    private IClienteRepository repository;

	@Override
	@Transactional
	public Cliente addCliente(ClienteDto p) {
		LOGGER.debug("Adding a new to-do entry with information: {}", p);

		Cliente model = Cliente.getBuilder().build();
		
		model.setNombre(p.getNombre());
		model.setApellido(p.getApellido());
		
        return repository.save(model);
	}
	
	@Override
	@Transactional
	public Cliente updateCliente(ClienteDto p) throws ClienteNotFoundException {
		
		LOGGER.debug("Updating contact with information: {}", p);

        Cliente model = getClienteById(p.getId());
        LOGGER.debug("Found a to-do entry: {}", model);

        model.update(p.getNombre(), p.getApellido());

        return model;
	}

	@Override
	@Transactional
	public List<Cliente> listClientes() {
		LOGGER.debug("Finding all to-do entries");
		return repository.findAll();
	}

	@Override
	@Transactional
	public Cliente getClienteById(int id)  throws ClienteNotFoundException {
		LOGGER.debug("Finding a to-do entry with id: {}", id);
		
		Cliente found = repository.findOne(id);
		LOGGER.debug("Found to-do entry: {}", found);
		
		if (found == null) {
		    throw new ClienteNotFoundException("No to-entry found with id: " + id);
		}
		
		return found;
	}

	@Override
	@Transactional
	public Cliente removeCliente(int id) throws ClienteNotFoundException {
		LOGGER.debug("Deleting a to-do entry with id: {}", id);
		
		Cliente deleted = getClienteById(id);
		LOGGER.debug("Deleting to-do entry: {}", deleted);
		
		repository.delete(deleted);
		return deleted;
	}

	@Override
	@Transactional
	public Boolean isValidUser(String nombre, String password) {
		//return this.ClienteDAO.isValidUser(nombre, password);
		List<Cliente> lst = repository.findByLoginYPassword(nombre, password);
		if (lst.isEmpty())
			return false;
		else
			return true;

	}

}
