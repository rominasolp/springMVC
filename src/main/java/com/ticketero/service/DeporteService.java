package com.ticketero.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketero.dto.DeporteDto;
import com.ticketero.exception.DeporteNotFoundException;

import com.ticketero.model.Deporte;

import com.ticketero.repository.IDeporteRepository;

@Service
public class DeporteService implements IDeporteService {

	private static final Logger LOGGER = LoggerFactory.getLogger(IDeporteRepository.class);

    @Resource
    private IDeporteRepository repository;
    
	@Override
	@Transactional
	public Deporte addDeporte(DeporteDto p) {
		LOGGER.debug("Adding a new to-do entry with information: {}", p);

		Deporte model = Deporte.getBuilder().build();
		
		model.setDeporte(p.getDeporte());
		model.setEvento_id(p.getEvento_id());

		return repository.saveAndFlush(model);
	}

	@Override
	@Transactional
	public Deporte updateDeporte(DeporteDto p) throws DeporteNotFoundException {
		LOGGER.debug("Updating contact with information: {}", p);

        Deporte model = getDeporteById(p.getId());
        LOGGER.debug("Found a to-do entry: {}", model);

        model.update(p.getDeporte());

        return model;
	}

	@Override
	@Transactional
	public List<Deporte> listDeportes() {
		LOGGER.debug("Finding all to-do entries");
		return repository.findAll();
	}

	@Override
	@Transactional
	public Deporte getDeporteById(Integer id) throws DeporteNotFoundException {
		LOGGER.debug("Finding a to-do entry with id: {}", id);
		
		Deporte found = repository.findOne(id);
		LOGGER.debug("Found to-do entry: {}", found);
		
		if (found == null) {
		    throw new DeporteNotFoundException("No to-entry found with id: " + id);
		}
		
		return found;
	}

	@Override
	@Transactional
	public Deporte removeDeporte(Integer id) throws DeporteNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Deporte getDeporteByIdDeEvento(Integer id) throws DeporteNotFoundException {
		LOGGER.debug("Finding a to-do entry with id: {}", id);
		
		Deporte found = repository.getDeporteByIdDeEvento(id);
		LOGGER.debug("Found to-do entry: {}", found);
		
		if (found == null) {
		    throw new DeporteNotFoundException("No to-entry found with id: " + id);
		}
		
		return found;
	}

}
