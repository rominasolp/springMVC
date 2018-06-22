package com.ticketero.service;

import java.util.List;

import com.ticketero.model.Deporte;
import com.ticketero.model.Evento;
import com.ticketero.model.Musica;
import com.ticketero.model.Pelicula;
import com.ticketero.model.Teatro;

public interface EventoService {
	
	public void addEvento(Evento p);
	public void updateEvento(Evento p);
	public List<Evento> listEventos();
	public Evento getEventoById(int id);
	public void removeEvento(int id);	

}
