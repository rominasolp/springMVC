package com.ticketero.service;

import java.util.List;

import com.ticketero.model.Pelicula;

public interface PeliculaService {

	public void addPelicula(Pelicula p);
	public void updatePelicula(Pelicula p);
	public List<Pelicula> listPelicula();
	public Pelicula getPeliculaById(int id);
	public void removePelicula(int id);
}
