package com.ticketero.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketero.dto.MusicaDto;
import com.ticketero.exception.MusicaNotFoundException;

import com.ticketero.model.Musica;

import com.ticketero.repository.IMusicaRepository;

@Service
public class MusicaService implements IMusicaService {

	private static final Logger LOGGER = LoggerFactory.getLogger(IMusicaRepository.class);

    @Resource
    private IMusicaRepository repository;
    
	@Override
	@Transactional
	public Musica addMusica(MusicaDto p) {
		LOGGER.debug("Adding a new to-do entry with information: {}", p);

		Musica model = Musica.getBuilder().build();
		
		model.setEstilo(p.getEstilo());
		model.setEvento_id(p.getEvento_id());

		return repository.saveAndFlush(model);
	}

	@Override
	@Transactional
	public Musica updateMusica(MusicaDto p) throws MusicaNotFoundException {
		LOGGER.debug("Updating contact with information: {}", p);

        Musica model = getMusicaById(p.getId());
        LOGGER.debug("Found a to-do entry: {}", model);

        model.update(p.getEstilo());

        return model;
	}

	@Override
	@Transactional
	public List<Musica> listMusicas() {
		LOGGER.debug("Finding all to-do entries");
		return repository.findAll();
	}

	@Override
	@Transactional
	public Musica getMusicaById(Integer id) throws MusicaNotFoundException {
		LOGGER.debug("Finding a to-do entry with id: {}", id);
		
		Musica found = repository.findOne(id);
		LOGGER.debug("Found to-do entry: {}", found);
		
		if (found == null) {
		    throw new MusicaNotFoundException("No to-entry found with id: " + id);
		}
		
		return found;
	}

	@Override
	@Transactional
	public Musica removeMusica(Integer id) throws MusicaNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Musica getMusicaByIdDeEvento(Integer id) throws MusicaNotFoundException {
		LOGGER.debug("Finding a to-do entry with id: {}", id);
		
		Musica found = repository.getMusicaByIdDeEvento(id);
		LOGGER.debug("Found to-do entry: {}", found);
		
		if (found == null) {
		    throw new MusicaNotFoundException("No to-entry found with id: " + id);
		}
		
		return found;
	}

}
