package com.ticketero.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketero.dto.EventoDto;

import com.ticketero.exception.EventoNotFoundException;

import com.ticketero.model.Evento;
import com.ticketero.repository.IEventoRepository;

@Service
public class EventoService implements IEventoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(IEventoRepository.class);

    @Resource
    private IEventoRepository repository;
    
	@Override
	@Transactional
	public Evento addEvento(EventoDto p) {
		LOGGER.debug("Adding a new to-do entry with information: {}", p);

		Evento model = Evento.getBuilder().build();
		//Evento modelR = new Evento(); 
		
		model.setId(p.getId());
		
		model.setNombreEvento(p.getNombre_de_evento());
		model.setDescripcion(p.getDescripcion());
		model.setPrecio(p.getPrecio());
		model.setDireccion(p.getDireccion());
		model.setStock(p.getStock());
		model.setFechaDesde(p.getFecha_desde());
		model.setFechaHasta(p.getFecha_hasta());
		model.setIdTipoDeEvento(p.getTipo_de_evento().getId());
		
        return repository.saveAndFlush(model);
		//modelR = repository.save(model);
		//return modelR;
        
	}

	@Override
	@Transactional
	public Evento updateEvento(EventoDto p) throws EventoNotFoundException {
		LOGGER.debug("Updating contact with information: {}", p);

        Evento model = getEventoById(p.getId());
        LOGGER.debug("Found a to-do entry: {}", model);

        model.update(p.getNombre_de_evento(), 
        		p.getDescripcion(),
        	    p.getDireccion(),
        	    p.getFecha_desde(),
        	    p.getFecha_hasta(),
        	    p.getPrecio(),
        	    p.getStock(),
        	    p.getTipo_de_evento().getId());

        return model;
	}

	@Override
	@Transactional
	public List<Evento> listEventos() {
		LOGGER.debug("Finding all to-do entries");
		return repository.findAll();
	}

	@Override
	@Transactional
	public Evento getEventoById(int id) throws EventoNotFoundException {
		LOGGER.debug("Finding a to-do entry with id: {}", id);
		
		Evento found = repository.findOne(id);
		LOGGER.debug("Found to-do entry: {}", found);
		
		if (found == null) {
		    throw new EventoNotFoundException("No to-entry found with id: " + id);
		}
		
		return found;
	}

	@Override
	@Transactional
	public Evento removeEvento(int id) throws EventoNotFoundException {
		LOGGER.debug("Deleting a to-do entry with id: {}", id);
		
		Evento deleted = getEventoById(id);
		LOGGER.debug("Deleting to-do entry: {}", deleted);
		
		repository.delete(deleted);
		return deleted;
	}

}
