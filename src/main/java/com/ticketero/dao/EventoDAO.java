package com.ticketero.dao;

import java.util.List;

import com.ticketero.model.Evento;

public interface EventoDAO {

	public void addEvento(Evento p);
	public void updateEvento(Evento p);
	public List<Evento> listEventos();
	public Evento getEventoById(int id);
	public void removeEvento(int id);
}
