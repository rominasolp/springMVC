package com.ticketero.service;

import java.util.List;

import com.ticketero.dto.EventoDto;
import com.ticketero.exception.EventoNotFoundException;
import com.ticketero.model.Evento;

public interface IEventoService {

	public Evento addEvento(EventoDto p);
	public Evento updateEvento(EventoDto p) throws EventoNotFoundException;
	public List<Evento> listEventos();
	public Evento getEventoById(int id) throws EventoNotFoundException;
	public Evento removeEvento(int id)throws EventoNotFoundException;
}
