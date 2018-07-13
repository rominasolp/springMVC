package com.ticketero.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketero.dto.TeatroDto;
import com.ticketero.exception.TeatroNotFoundException;

import com.ticketero.model.Teatro;

import com.ticketero.repository.ITeatroRepository;

@Service
public class TeatroService implements ITeatroService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ITeatroRepository.class);

    @Resource
    private ITeatroRepository repository;
    
	@Override
	@Transactional
	public Teatro addTeatro(TeatroDto p) {
		LOGGER.debug("Adding a new to-do entry with information: {}", p);

		Teatro model = Teatro.getBuilder().build();
		
		model.setGenero(p.getGenero());
		model.setEvento_id(p.getEvento_id());

		return repository.saveAndFlush(model);
	}

	@Override
	@Transactional
	public Teatro updateTeatro(TeatroDto p) throws TeatroNotFoundException {
		LOGGER.debug("Updating contact with information: {}", p);

        Teatro model = getTeatroById(p.getId());
        LOGGER.debug("Found a to-do entry: {}", model);

        model.update(p.getGenero());

        return model;
	}

	@Override
	@Transactional
	public List<Teatro> listTeatros() {
		LOGGER.debug("Finding all to-do entries");
		return repository.findAll();
	}

	@Override
	@Transactional
	public Teatro getTeatroById(Integer id) throws TeatroNotFoundException {
		LOGGER.debug("Finding a to-do entry with id: {}", id);
		
		Teatro found = repository.findOne(id);
		LOGGER.debug("Found to-do entry: {}", found);
		
		if (found == null) {
		    throw new TeatroNotFoundException("No to-entry found with id: " + id);
		}
		
		return found;
	}

	@Override
	@Transactional
	public Teatro removeTeatro(Integer id) throws TeatroNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Teatro getTeatroByIdDeEvento(Integer id) throws TeatroNotFoundException {
		LOGGER.debug("Finding a to-do entry with id: {}", id);
		
		Teatro found = repository.getTeatroByIdDeEvento(id);
		LOGGER.debug("Found to-do entry: {}", found);
		
		if (found == null) {
		    throw new TeatroNotFoundException("No to-entry found with id: " + id);
		}
		
		return found;
	}

}
