package com.ticketero.service;

import java.util.List;

import com.ticketero.model.Musica;

public interface MusicaService {

	public void addMusica(Musica p);
	public void updateMusica(Musica p);
	public List<Musica> listMusicas();
	public Musica getMusicaById(int id);
	public void removeMusica(int id);
}
