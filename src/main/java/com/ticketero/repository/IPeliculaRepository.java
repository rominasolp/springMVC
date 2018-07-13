package com.ticketero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketero.model.Pelicula;

public interface IPeliculaRepository extends JpaRepository<Pelicula, Integer> {
	
	 @Query("SELECT p FROM Pelicula p  WHERE p.evento_id=(:pEvento)")	 
	 public Pelicula getPeliculaByIdDeEvento(@Param("pEvento") Integer pEvento);
	 
}
