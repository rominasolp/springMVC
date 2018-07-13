package com.ticketero.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketero.dto.PeliculaDto;
import com.ticketero.exception.PeliculaNotFoundException;

import com.ticketero.model.Pelicula;

import com.ticketero.repository.IPeliculaRepository;

@Service
public class PeliculaService implements IPeliculaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(IPeliculaRepository.class);

    @Resource
    private IPeliculaRepository repository;
    
	@Override
	@Transactional
	public Pelicula addPelicula(PeliculaDto p) {
		LOGGER.debug("Adding a new to-do entry with information: {}", p);

		Pelicula model = Pelicula.getBuilder().build();
		
		model.setGenero(p.getGenero());
		model.setEvento_id(p.getEvento_id());

		return repository.saveAndFlush(model);
	}

	@Override
	@Transactional
	public Pelicula updatePelicula(PeliculaDto p) throws PeliculaNotFoundException {
		LOGGER.debug("Updating contact with information: {}", p);

        Pelicula model = getPeliculaById(p.getId());
        LOGGER.debug("Found a to-do entry: {}", model);

        model.update(p.getGenero());

        return model;
	}

	@Override
	@Transactional
	public List<Pelicula> listPeliculas() {
		LOGGER.debug("Finding all to-do entries");
		return repository.findAll();
	}

	@Override
	@Transactional
	public Pelicula getPeliculaById(Integer id) throws PeliculaNotFoundException {
		LOGGER.debug("Finding a to-do entry with id: {}", id);
		
		Pelicula found = repository.findOne(id);
		LOGGER.debug("Found to-do entry: {}", found);
		
		if (found == null) {
		    throw new PeliculaNotFoundException("No to-entry found with id: " + id);
		}
		
		return found;
	}

	@Override
	@Transactional
	public Pelicula removePelicula(Integer id) throws PeliculaNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Pelicula getPeliculaByIdDeEvento(Integer id) throws PeliculaNotFoundException {
		LOGGER.debug("Finding a to-do entry with id: {}", id);
		
		Pelicula found = repository.getPeliculaByIdDeEvento(id);
		LOGGER.debug("Found to-do entry: {}", found);
		
		if (found == null) {
		    throw new PeliculaNotFoundException("No to-entry found with id: " + id);
		}
		
		return found;
	}

}
