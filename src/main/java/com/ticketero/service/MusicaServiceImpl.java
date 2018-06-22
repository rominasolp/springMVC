package com.ticketero.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ticketero.dao.MusicaDAO;
import com.ticketero.model.Musica;

@Service
public class MusicaServiceImpl implements MusicaService {

	private MusicaDAO musicaDAO;

	public void setMusicDAO(MusicaDAO miDAO) {
		this.musicaDAO = miDAO;
	}
	
	
	@Override
	@Transactional
	public void addMusica(Musica p) {
		this.musicaDAO.addMusica(p);		
	}

	@Override
	@Transactional
	public void updateMusica(Musica p) {
		this.musicaDAO.updateMusica(p);
		
	}

	@Override
	@Transactional
	public List<Musica> listMusicas() {
		return this.musicaDAO.listMusicas();
	}

	@Override
	@Transactional
	public Musica getMusicaById(int id) {
		return this.musicaDAO.getMusicaById(id);
	}

	@Override
	@Transactional
	public void removeMusica(int id) {
		this.musicaDAO.removeMusica(id);		
	}

}
