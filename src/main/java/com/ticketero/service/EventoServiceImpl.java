package com.ticketero.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketero.dao.DeporteDAO;
import com.ticketero.dao.EventoDAO;
import com.ticketero.dao.MusicaDAO;
import com.ticketero.dao.PeliculaDAO;
import com.ticketero.dao.TeatroDAO;
import com.ticketero.model.Deporte;
import com.ticketero.model.Evento;
import com.ticketero.model.Musica;
import com.ticketero.model.Pelicula;
import com.ticketero.model.Teatro;

@Service
public class EventoServiceImpl implements EventoService {

	private EventoDAO eventoDao;
	private TeatroDAO teatroDao;
	private PeliculaDAO peliculaDao;
	private DeporteDAO deporteDao;
	private MusicaDAO musicaDao;
	
	public void setEventoDAO(EventoDAO eventoDAO) {
		this.eventoDao = eventoDAO;
	}
	
	public void setEventoTeatroDAO(TeatroDAO teatroDAO) {
		this.teatroDao = teatroDAO;
	}
	
	public void setEventoPeliculDAO(PeliculaDAO peliculaDAO) {
		this.peliculaDao = peliculaDAO;
	}
	
	public void setEventoDeporteDAO(DeporteDAO deporteDAO) {
		this.deporteDao = deporteDAO;
	}
	
	public void setEventoMusicaDAO(MusicaDAO musicaDAO) {
		this.musicaDao = musicaDAO;
	}
	
	@Override
	@Transactional	
	public void addEvento(Evento p) {
		this.eventoDao.addEvento(p);
	}

	@Override
	@Transactional	
	public void updateEvento(Evento p) {
		this.eventoDao.updateEvento(p);
		
	}

	@Override
	@Transactional
	public List<Evento> listEventos() {
		return this.eventoDao.listEventos();
	}

	@Override
	@Transactional
	public Evento getEventoById(int id) {
		return this.eventoDao.getEventoById(id);
	}

	@Override
	@Transactional
	public void removeEvento(int id) {
		this.eventoDao.removeEvento(id);
		
	}	

}
