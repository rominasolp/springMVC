package com.ticketero.service;

import java.util.List;

import com.ticketero.dto.MusicaDto;
import com.ticketero.exception.MusicaNotFoundException;
import com.ticketero.model.Musica;

public interface IMusicaService {

	public Musica addMusica(MusicaDto p);
	public Musica updateMusica(MusicaDto p) throws MusicaNotFoundException;
	public List<Musica> listMusicas();
	public Musica getMusicaById(Integer id) throws MusicaNotFoundException;
	public Musica removeMusica(Integer id)throws MusicaNotFoundException;
	public Musica getMusicaByIdDeEvento(Integer id) throws MusicaNotFoundException;
	
}
