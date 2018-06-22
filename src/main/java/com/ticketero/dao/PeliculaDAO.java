package com.ticketero.dao;
import java.util.List;

import com.ticketero.model.Pelicula;

public interface PeliculaDAO {

	public void addPelicula(Pelicula p);
	public void updatePelicula(Pelicula p);
	public List<Pelicula> listPeliculas();
	public Pelicula getPeliculaById(int id);
	public void removePelicula(int id);
	
}
