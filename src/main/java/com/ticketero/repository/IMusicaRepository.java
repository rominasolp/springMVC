package com.ticketero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ticketero.model.Musica;

public interface IMusicaRepository extends JpaRepository<Musica, Integer> {
	
	 @Query("SELECT m FROM Musica m  WHERE m.evento_id=(:pEvento)")	 
	 public Musica getMusicaByIdDeEvento(@Param("pEvento") Integer pEvento);
	 
}
