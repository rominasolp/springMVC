package com.ticketero.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketero.dto.TipoEventoDto;
import com.ticketero.exception.TipoDeEventoNotFoundException;
import com.ticketero.model.TipoDeEvento;

import com.ticketero.repository.ITipoDeEventoRepository;

@Service
public class TipoDeEventoService implements ITipoDeEventoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ITipoDeEventoRepository.class);

    @Resource
    private ITipoDeEventoRepository repository;
    
	@Override
	@Transactional
	public TipoDeEvento addTipoDeEvento(TipoEventoDto p) {
		LOGGER.debug("Adding a new to-do entry with information: {}", p);

		TipoDeEvento model = TipoDeEvento.getBuilder().build();
		
		model.setNombre(p.getNombre());
		
        return repository.save(model);
	}

	@Override
	@Transactional
	public TipoDeEvento updateTipoDeEvento(TipoEventoDto p) throws TipoDeEventoNotFoundException {
		LOGGER.debug("Updating contact with information: {}", p);

        TipoDeEvento model = getTipoDeEventoById(p.getId());
        LOGGER.debug("Found a to-do entry: {}", model);

        model.update(p.getNombre());

        return model;
	}

	@Override
	@Transactional
	public List<TipoDeEvento> listTipoDeEventos() {
		LOGGER.debug("Finding all to-do entries");
		return repository.findAll();
	}

	@Override
	@Transactional
	public TipoDeEvento getTipoDeEventoById(int id) throws TipoDeEventoNotFoundException {
LOGGER.debug("Finding a to-do entry with id: {}", id);
		
		TipoDeEvento found = repository.findOne(id);
		LOGGER.debug("Found to-do entry: {}", found);
		
		if (found == null) {
		    throw new TipoDeEventoNotFoundException("No to-entry found with id: " + id);
		}
		
		return found;
	}

	@Override
	@Transactional
	public TipoDeEvento removeTipoDeEvento(int id) throws TipoDeEventoNotFoundException {
		LOGGER.debug("Deleting a to-do entry with id: {}", id);
		
		TipoDeEvento deleted = getTipoDeEventoById(id);
		LOGGER.debug("Deleting to-do entry: {}", deleted);
		
		repository.delete(deleted);
		return deleted;
	}

}
