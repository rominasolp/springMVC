package com.ticketero.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ticketero.dao.PeliculaDAO;
import com.ticketero.model.Pelicula;

@Service
public class PeliculaServiceImpl implements PeliculaService {

	private PeliculaDAO peliculaDAO;

	public void setPeliDAO(PeliculaDAO miDAO) {
		this.peliculaDAO = miDAO;
	}
	
	@Override
	public void addPelicula(Pelicula p) {
		this.peliculaDAO.addPelicula(p);
		
	}

	@Override
	public void updatePelicula(Pelicula p) {
		this.peliculaDAO.updatePelicula(p);
		
	}

	@Override
	public List<Pelicula> listPelicula() {
		return this.peliculaDAO.listPeliculas();
	}

	@Override
	public Pelicula getPeliculaById(int id) {	
		return this.peliculaDAO.getPeliculaById(id);
	}

	@Override
	public void removePelicula(int id) {
		this.peliculaDAO.removePelicula(id);
	}

}
