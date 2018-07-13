package com.ticketero.service;

import java.util.List;

import com.ticketero.dto.PeliculaDto;
import com.ticketero.exception.PeliculaNotFoundException;
import com.ticketero.model.Pelicula;

public interface IPeliculaService {

	public Pelicula addPelicula(PeliculaDto p);
	public Pelicula updatePelicula(PeliculaDto p) throws PeliculaNotFoundException;
	public List<Pelicula> listPeliculas();
	public Pelicula getPeliculaById(Integer id) throws PeliculaNotFoundException;
	public Pelicula removePelicula(Integer id)throws PeliculaNotFoundException;
	public Pelicula getPeliculaByIdDeEvento(Integer id) throws PeliculaNotFoundException;
	
}
